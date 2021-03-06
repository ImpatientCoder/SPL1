package spl1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;



public class PhotoEditingFeatures extends JPanel implements ActionListener
{	

	
	public JFrame frame;
	
	Timer timer;
	int delay = 10;
	int x = 200, y = 0, directionX=2, directionY=2;
	
	boolean seeAnimation=false;	
	public BufferedImage image;
	
	
			
	public PhotoEditingFeatures(JFrame frame)
	{	
		this.frame=frame;
		timer = new Timer(delay,this);
		timer.start();

	}
	
	
		
	
	public void paintComponent(Graphics g)
	{	
		g.fillRect(0,0, 700, 700);
		g.drawImage(image,x,y,300,300,null);		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{	
		if(seeAnimation)
		{
			
			x+=directionX;
			y+=directionY;
			
			if(x<=0 || x>=400)
			{	
				directionX*=-1;
			}
			if(y<=0 || y>=400)
			{	
				directionY*=-1;
			}
			
		}
		repaint();		
	}



	
	
	
	
	public void makeAnimation(BufferedImage image)
	{
		
		if(image == null)
		{
		   System.out.println("Please, open the File Menu \n And Select an image to edit...\n\n");
		   return;
		}
		
		
		this.image=image;	
		seeAnimation=true;
		
	}
	
	

	
	
	
	public void makeNegative(BufferedImage image)
	{
		
			if(image == null)
			{
				   System.out.println("Please, open the File Menu \n And Select an image to edit...\n\n");
				   return;
			}
				
				    
		   int row = image.getHeight();	//get image width and height
		   int column = image.getWidth();
		    
		   for(int i = 0; i < row; i++)
		   {
		      for(int j = 0; j < column; j++)
		      {
		    	  
		        int pixel = image.getRGB(j, i);
		        
		        int alpha = (pixel>>24) & 0xff;
		        int red	  = (pixel>>16) & 0xff;
		        int green = (pixel>>8)  & 0xff;
		        int blue  =  pixel & 0xff;
		      
		        red   = 255 - red;
		        green = 255 - green;
		        blue  = 255 - blue;
		       
		        pixel = (alpha<<24) | (red<<16) | (green<<8) | blue;  //subtract RGB from 255 //convert to negative
		        image.setRGB(j, i, pixel);
		      }
		      
		   }
		  
		    try
		    {
		      File file = new File("C:\\Users\\Md. Alamgir Kabir\\Documents\\Output.jpg");
		      ImageIO.write(image, "jpg", file);
		    }catch(IOException e)
		    {
		      System.out.println(e);
		    }	   
		  
	}
	

	
	
	
	
	public void makeMirror(BufferedImage image)
	{
		if(image == null)
		{
		   System.out.println("Please, open the File Menu \n And Select an image to edit...\n\n");
		   return;
		}
			
	    int column = image.getWidth();  //width means how many columns are in...(pixels in horizontal)
	    int	row = image.getHeight();	//hight means how many rows are in...(pixels in vertical)
	    
	    
	  //Create pixel Array
		
		int[][] pixels = new int[column][row];
		
		for( int i = 0; i < column; i++ )
		{
		    for( int j = 0; j < row; j++ )
		    {	    	
		    	pixels[i][j] = image.getRGB(i, j);		    		
		    }
		}		
	
		//image format (column*row) pixel
		//width(refers column number) 0 1 2 3...
		//hight(refers row number)	  (0,0),(0,1), (0,2)...up to down	
		//This is actually Column swapping (First column <----> Last Column) 

		
		//Create mirror using pixel array
	    
		 for (int i = 0; i < column/2; i++)
		 {
	            for (int j = 0; j < row; j++)
	            {
	                int temp     = pixels[i][j];
	                pixels[i][j] = pixels[column-1-i][j]; //highest index = totalSize-1; 
	                pixels[column-1-i][j] = temp;
	            }
		 }
		 
		for( int i = 0; i < column; i++ ) 
		{
			    for( int j = 0; j < row; j++ )
			    {
			        image.setRGB(i, j, pixels[i][j]);
			    }
			    
		}
		 
	}
	

	
	
	
	public void rotateImage(BufferedImage image)
	{
		
		if(image == null)
		{
			   System.out.println("Please, open the File Menu \n And Select an image to edit...\n\n");
			   return;
		}
		
		
		
	    int width = image.getWidth();
	    int	hight = image.getHeight();
	    
		int[][] pixels = new int [hight][width];
		
		
		
		for( int i = 0; i < hight; i++ )
		{
		    for( int j = 0; j < width; j++ )
		    {	    	
		    	pixels[i][j] = image.getRGB(i, j);		    		
		    }
		}
		
		
		
		int[][] rotatePixels = new int[width][hight];
		
		for( int i = 0; i < width; i++ )
		{
		    for( int j = 0; j < hight; j++ )
		    {	    
		    	rotatePixels[i][j] = pixels[hight-j-1][i];
		    	image.setRGB(i, j, rotatePixels[i][j]);
		    }
		}
		
		
		
//		for( int i = 0; i < hight; i++ ) 
//		{
//			    for( int j = 0; j < width; j++ )
//			    {
//			        image.setRGB(i, j, rotatePixels[j][i]);
//			    }
//			    
//		 }
		
		
	
	}
	

	
	
	
	public void makeBlackWhite(BufferedImage image) throws IOException
	{
		
		if(image == null)
		{
			   System.out.println("Please, open the File Menu \n And Select an image to edit...\n\n");
			   return;
		}
		
	    int column = image.getWidth();
	    int	row = image.getHeight();
	    
	    
		for( int i = 0; i < column; i++ ) 
		{
			    for( int j = 0; j < row; j++ )
			    {
			        int pixel  = image.getRGB(i, j);
			        
			        System.out.print((pixel >>16) & 0xff);
			        
			        int alpha = (pixel >>24) & 0xff;
			        int red	  = (pixel >>16) & 0xff;
			        int green = (pixel >>8)  & 0xff;
			        int blue  =  pixel & 0xff;
			        
			        int average = (red + green + blue)/3;
//			        
//			        red = average;
//			        green = average;
//			        blue = average;
			        
			        if( (average*2) > 255)
			        {
			        	red   = 255; 
			        	green = 255;
			        	blue  = 255;
			        }
			        else
			        {
			        	red   = 0; 
			        	green = 0;
			        	blue  = 0;			        	
			        }
			        
			        pixel = (alpha<<24)| (red<<16)| (green<<8)| blue;			        
			        image.setRGB(i, j, pixel);
			        
			    }
			    
		 }
		
				
	}

	
	

	
	
	
	public void makeEdgeImage(BufferedImage image)
	{
		   if(image == null)
		   {
			   System.out.println("Please, open the File Menu \n And Select an image to edit...\n\n");
			   return;
		   }
		   
		   int w = image.getWidth();
		   int h = image.getHeight();
		
		
		//Create pixel Array
		
		int[][] pixels = new int[w][h];

		for( int i = 0; i < w; i++ )
		{
		    for( int j = 0; j < h; j++ )
		    {
		        pixels[i][j] = image.getRGB(i, j);
			//System.out.println(pixels[i][j]);
		    }
		}    

		   
		   
	}

	
	
	
	
	public void makeRedImage(BufferedImage image)
	{
		
		
		   if(image == null)
		   {
			   System.out.println("Please, open the File Menu \n And Select an image to edit...\n\n");
			   return;
		   }
		
				    
		   int row = image.getHeight();		//get image width and height
		   int column = image.getWidth();
		   
		   
		    
		   for(int i = 0; i < row; i++)
		   {
		      for(int j = 0; j < column; j++)
		      {
		    	  
		        int pixel = image.getRGB(j, i);
		        
		        int alpha = (pixel>>24) & 0xff;
		        int red	  = (pixel>>16) & 0xff;
		        int green = (pixel>>8)  & 0xff;
		        int blue  =  pixel & 0xff;
		      
		        red   = 255 ;

		       
		        pixel = (alpha<<24) | (red<<16) | (green<<8) | blue;  //subtract RGB from 255 //convert to negative
		        image.setRGB(j, i, pixel);
		      }
		      
		   }
		  	  
	 }


	
	
	

	public void makeBlueImage(BufferedImage image)
	{
		
		
		   if(image == null)
		   {
			   System.out.println("Please, open the File Menu \n And Select an image to edit...\n\n");
			   return;
		   }
		
				    
		   int row = image.getHeight();		//get image width and height
		   int column = image.getWidth();
		   
		   
		    
		   for(int i = 0; i < row; i++)
		   {
		      for(int j = 0; j < column; j++)
		      {
		    	  
		        int pixel = image.getRGB(j, i);
		        
		        int alpha = (pixel>>24) & 0xff;
		        int red	  = (pixel>>16) & 0xff;
		        int green = (pixel>>8)  & 0xff;
		        int blue  =  pixel & 0xff;
		      
		        blue   = 255 ;

		       
		        pixel = (alpha<<24) | (red<<16) | (green<<8) | blue;  //subtract RGB from 255 //convert to negative
		        image.setRGB(j, i, pixel);
		      }
		      
		   }
		  	  
	 }
	
	
	
	
	

	public void makeGreenImage(BufferedImage image)
	{
		
		
		   if(image == null)
		   {
			   System.out.println("Please, open the File Menu \n And Select an image to edit...\n\n");
			   return;
		   }
		
				    
		   int row = image.getHeight();		//get image width and height
		   int column = image.getWidth();
		   
		   
		    
		   for(int i = 0; i < row; i++)
		   {
		      for(int j = 0; j < column; j++)
		      {
		    	  
		        int pixel = image.getRGB(j, i);
		        
		        int alpha = (pixel>>24) & 0xff;
		        int red	  = (pixel>>16) & 0xff;
		        int green = (pixel>>8)  & 0xff;
		        int blue  =  pixel & 0xff;
		      
		        green   = 255 ;

		       
		        pixel = (alpha<<24) | (red<<16) | (green<<8) | blue;  //subtract RGB from 255 //convert to negative
		        image.setRGB(j, i, pixel);
		      }
		      
		   }
		   
		  	  
	 }
	
	
	
	
	
	
	
	public void makeGrayScaleImage(BufferedImage image) throws IOException
	{
		
		if(image == null)
		{
			   System.out.println("Please, open the File Menu \n And Select an image to edit...\n\n");
			   return;
		}
		
		
	    int column = image.getWidth();
	    int	row = image.getHeight();
	    
	    
		for( int i = 0; i < column; i++ ) 
		{
			
			    for( int j = 0; j < row; j++ )
			    {
			    	
			    	
			        int pixel  = image.getRGB(i, j);
			        
			        
			        
			        int alpha = (pixel >>24) & 0xff;
			        int red	  = (pixel >>16) & 0xff;
			        int green = (pixel >>8)  & 0xff;
			        int blue  =  pixel & 0xff;
			        
			        
			        int average = (red + green + blue)/3;
			        
			        
			        red = average;
			        green = average;
			        blue = average;
			        
			        
			        
			        pixel = (alpha<<24)| (red<<16)| (green<<8)| blue;			        
			        image.setRGB(i, j, pixel);
			        
			    }
			    
		 }
		
		
				
	}

	
	

				
		
}
