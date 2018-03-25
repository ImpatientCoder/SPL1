package spl1;

import java.awt.BorderLayout;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PhotoEditingFeatures
{
			
	public PhotoEditingFeatures()
	{

	}
	

	public void makeNegative(BufferedImage image)
	{
				    
		   int hight = image.getHeight();	//get image width and height
		   int width = image.getWidth();
		    
		   for(int i = 0; i < hight; i++)
		   {
		      for(int j = 0; j < width; j++)
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
	    int count = 0;
	    int column = image.getWidth();  //width means how many columns are in...(pixels in horizontal)
	    int	row = image.getHeight();	//hight means how many rows are in...(pixels in vertical)
	    
	    System.out.println(column+"	"+row);
	    
	  //Create pixel Array
		
		int[][] pixels = new int[column][row];
		
		for( int i = 0; i < column; i++ )
		{
		    for( int j = 0; j < row; j++ )
		    {	    	
		    	pixels[i][j] = image.getRGB(i, j);		    	
		    	count++;	
		    }
		}		
		System.out.println(count);
		
		//image format (column*row) pixel
		//width(refers column number) 0 1 2 3...
		//hight(refers row number)	  (0,0),(0,1), (0,2)...up to down	
		//0 er jonno ek column porbe, then 1 er jonno ek column..

		
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
			    for( int j = 0; j < row; j++ ){
			        image.setRGB(i, j, pixels[i][j]);
			    }
			    
		}
		 
	}
	
//Create pixel Array
	
//	int[][] pixels = new int[w][h];
//
//	for( int i = 0; i < w; i++ )
//	    for( int j = 0; j < h; j++ )
//	        pixels[i][j] = img.getRGB( i, j );
//	System.out.println(pixels[i][j]);
	
	public void rotateImage(BufferedImage image)
	{
		
	    int column = image.getWidth();
	    int	row = image.getHeight();
	    
		int[][] pixels = new int[column][row];
		
		for( int i = 0; i < column; i++ )
		{
		    for( int j = 0; j < row; j++ )
		    {	    	
		    	pixels[i][j] = image.getRGB(i, j);		    		
		    }
		 }
		
		int[][] rotatePixels = new int[row][column];
		
		for( int i = 0; i < column; i++ )
		{
		    for( int j = 0; j < row; j++ )
		    {	    	
		    	rotatePixels[j][i] = pixels[i][row-1-j];		//??????????? //???????(0,row-1) no pixel goes to (0, 0)    // then (0,row-2)....(1,0)		
		    }
		}
		
		for( int i = 0; i < column; i++ ) 
		{
			    for( int j = 0; j < row; j++ )
			    {
			        image.setRGB(i, j, rotatePixels[j][i]);
			    }
			    
		 }
		
	
	}
	
	
	public void makeBlackWhite(BufferedImage image)
	{
	    int column = image.getWidth();
	    int	row = image.getHeight();
	    
		for( int i = 0; i < column; i++ ) 
		{
			    for( int j = 0; j < row; j++ )
			    {
			        int pixel  = image.getRGB(i, j);
			        
			        int alpha = (pixel>>24) & 0xff;
			        int red	  = (pixel>>16) & 0xff;
			        int green = (pixel>>8)  & 0xff;
			        int blue  =  pixel & 0xff;
			        
			        int average = (red + green + blue)/3;
			        
			        red = average;
			        green = average;
			        blue = average;
			        
//			        if( (average*2) > 255)
//			        {
//			        	red   = 255; 
//			        	green = 255;
//			        	blue  = 255;
//			        }
//			        else
//			        {
//			        	red   = 0; 
//			        	green = 0;
//			        	blue  = 0;			        	
//			        }
			        
			        pixel = (alpha<<24)| (red<<16)| (green<<8)| blue;			        
			        image.setRGB(i, j, pixel);
			        
			    }
			    
		 }
		
		
		
	}
	

	

}
