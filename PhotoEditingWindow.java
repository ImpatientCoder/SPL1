package spl1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PhotoEditingWindow implements ActionListener
{

	
	  JFrame frame = new JFrame("Photo Editor"); 
	    
	  JMenu FileMenu, Modify, Enhance, Filter, Export, Help;
	  
	  JMenuItem open, save, close;
	  JMenuItem rotation, mirror, drawing, negative;
	  JMenuItem contrast, curves, sharpness,  edges;
	  JMenuItem blackwhite, grayScale, vintage, thickness, red, green, blue, animation; 
	  
	  JFileChooser javaFileChooser = new JFileChooser("Enter an Image");  
	
	  JLabel welcomeLabel = new JLabel("WELCOME");
	  JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\Md. Alamgir Kabir\\Documents\\Sample3.jpg"));
	  JPanel imagePanel = new JPanel();
	  
	  public Image originalImage = null;
	  public BufferedImage bufferedImage ;
	  
	  
	  
		
	  public PhotoEditingWindow() throws IOException
	  {
		  createMenubar();
		  
		  bufferedImage=ImageIO.read(new File("C:\\Users\\Md. Alamgir Kabir\\Documents\\Sample3.jpg"));
	  }	

	
	  
	  
	  
	  public void createMenubar()
      { 
		  
     	 JMenuBar menubar  = new JMenuBar();
     	 
     	 FileMenu   = new JMenu("File");  
     	 Modify		= new JMenu("Modification");
     	 Enhance    = new JMenu("Enhancement");
     	 Filter		= new JMenu("Filter");
     	 Export		= new JMenu("Export");
     	 Help       = new JMenu("Help");
     	 
         //Create menu item to File
     	 
         open = new JMenuItem("Open");
         save = new JMenuItem("Save");  
         close = new JMenuItem("Close"); 

         
         FileMenu.add(open); 
         FileMenu.add(save); 
         FileMenu.add(close);
         
         open.addActionListener(this);         
         save.addActionListener(this);
         close.addActionListener(this);
         
       //Create menu item to Modification
         
         rotation = new JMenuItem("Rotate");
         mirror   = new JMenuItem("Mirror");
         drawing  = new JMenuItem("Draw");
         negative = new JMenuItem("Negative");
         
         Modify.add(negative);
         Modify.add(rotation);
         Modify.add(mirror); 
         Modify.add(drawing);
         
         rotation.addActionListener(this);         
         mirror.addActionListener(this);
         drawing.addActionListener(this);
         negative.addActionListener(this);
         
       //Create menu item to Enhancement  
         
         contrast  = new JMenuItem("Contrast");
         curves	   = new JMenuItem("Curves");	
         sharpness = new JMenuItem("Sharpness");
         edges     = new JMenuItem("Edges");
         
         contrast.addActionListener(this);
         curves.addActionListener(this);
         sharpness.addActionListener(this);
         edges.addActionListener(this);
         
         Enhance.add(contrast);
         Enhance.add(curves);
         Enhance.add(sharpness);
         Enhance.add(edges);
         
       //Create menu item to Filter & Export  
         
         blackwhite = new JMenuItem("Black/White");
         grayScale      = new JMenuItem("GrayScale");
         vintage 	= new JMenuItem("Vintage");
         thickness  = new JMenuItem("Thickness");
         animation  = new JMenuItem("See Animation");
         red = new JMenuItem("Red");
         green = new JMenuItem("Green");
         blue = new JMenuItem("Blue");
         
         blackwhite.addActionListener(this);
         grayScale.addActionListener(this);
         vintage.addActionListener(this);
         thickness.addActionListener(this);
         red.addActionListener(this);
         green.addActionListener(this);
         blue.addActionListener(this);
         animation.addActionListener(this);
         
         Filter.add(blackwhite);
         Filter.add(grayScale);
         Filter.add(animation);
         Filter.add(vintage);         

         Export.add(red);
         Export.add(green);
         Export.add(blue);
         Export.add(thickness);
         
       //Adding Menus to Menubar
         
         menubar.add(FileMenu);
         menubar.add(Modify);
         menubar.add(Filter);
         menubar.add(Export);
         menubar.add(Enhance);
         menubar.add(Help);
        
         frame.setJMenuBar(menubar);  

// 		Shape of the frame
         
// Choosing the specific file from file chooser
         
         FileNameExtensionFilter openFilter;
         openFilter = new FileNameExtensionFilter("EditingImageFile", "JPG", "jpg", "png", "jpeg","IMG");	
         javaFileChooser.setFileFilter(openFilter);
         
		 imageLabel.setSize(300,300);
         frame.add(imageLabel);
         frame.setSize(700, 700);  
         frame.setVisible(true);
         
         
      }
	  
	  

		@Override
		public void actionPerformed(ActionEvent e)
		{	
			
			
			PhotoEditingFeatures edit = new PhotoEditingFeatures(frame);
			JMenuItem operation = (JMenuItem) (e.getSource());
			
			
			if (operation.getText().equals("Open")) 
			{
				openFile();
			}
			
			
			
			else if (operation.getText().equals("Rotate"))
			{
				edit.rotateImage(bufferedImage);
				displayImage(bufferedImage);
			}
			
			
			
			else if (operation.getText().equals("Edges"))
			{
				edit.makeEdgeImage(bufferedImage);
				displayImage(bufferedImage);
			}
			
			
			else if (operation.getText().equals("Mirror"))
			{
				edit.makeMirror(bufferedImage);
				displayImage(bufferedImage);
			}
			
			
			else if (operation.getText().equals("Draw"))
			{
				// a method to Draw
			}
			
			
			else if (operation.getText().equals("Negative"))
			{
				
				edit.makeNegative(bufferedImage);
				displayImage(bufferedImage);
				//displayOriginalImage();	//???????				
			}
			
			
			else if (operation.getText().equals("Black/White")) 
			{
				try
				{
					edit.makeBlackWhite(bufferedImage);
				}catch (IOException e1)
				{
					e1.printStackTrace();
				}
				displayImage(bufferedImage);
			}
			

			
			else if (operation.getText().equals("GrayScale")) 
			{
				try
				{
					edit.makeGrayScaleImage(bufferedImage);
				}catch (IOException e1)
				{
					e1.printStackTrace();
				}
				displayImage(bufferedImage);
			}
			
			
			
			else if (operation.getText().equals("See Animation")) 
			{
				edit.makeAnimation(bufferedImage);
				frame.add(edit);
				frame.setVisible(true);
			}
			
			
			else if (operation.getText().equals("Save")) 
			{
			// a method to save
			}
			
			else if (operation.getText().equals("Red")) 
			{
				edit.makeRedImage(bufferedImage);
				displayImage(bufferedImage);
			}

			
			else if (operation.getText().equals("Blue")) 
			{
				edit.makeBlueImage(bufferedImage);
				displayImage(bufferedImage);
			}
			
			
			else if (operation.getText().equals("Green")) 
			{
				edit.makeGreenImage(bufferedImage);
				displayImage(bufferedImage);
			}

			
			else if (operation.getText().equals("Close")) 
			{
				System.exit(0);
			}

			
		}
		


		
		
		
		public void openFile()
		{
			
				int returnValue = javaFileChooser.showOpenDialog(javaFileChooser); // 0;
				
				
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{				
					
					String fileName = javaFileChooser.getSelectedFile().getAbsolutePath();
					
					File imageFile = new File(fileName);					
					try
					{
						originalImage = ImageIO.read(imageFile);
						bufferedImage = ImageIO.read(imageFile);
						displayImage(bufferedImage);
						
					}catch (IOException e){
						
						e.printStackTrace();
					}
					
					
					
				}
				
				
				
				else
				{
					JOptionPane.showMessageDialog(null, "Please select an Image");
				}
				
		}

		
		
		
		public void displayOriginalImage()
		{		
			imageLabel.setIcon(new ImageIcon(originalImage));	
		}



		public void displayImage(BufferedImage bufferedImage)
		{
			imageLabel.setIcon(new ImageIcon(bufferedImage));
		}
		
		

}