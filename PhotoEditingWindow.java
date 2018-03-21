import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;


import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class PhotoEditingWindow implements ActionListener
{
	
	  JFrame frame = new JFrame("Photo Editor");  
		
	  JMenu FileMenu, Modify, Enhance, Filter, Export, Help;
	  
	  JMenuItem open, save, close;
	  JMenuItem rotation, mirror, drawing, negative;
	  JMenuItem contrast, curves, sharpness,  edges;
	  JMenuItem blackwhite, punch, vintage, thickness;

	  
	  JFileChooser javaFileChooser = new JFileChooser("Enter an Image");
	  
	  JLabel imageLabel = new JLabel();
	  JPanel imagePanel = new JPanel();
	  
	  public BufferedImage bufferedImage;
	  public Image OriginalImage;
	  
	  public PhotoEditingWindow()
	  {
		  createMenubar();
	  }	

	  
	  
	  public void createMenubar()
      { 
		  
     	 JMenuBar MB  = new JMenuBar();
     	 
     	 
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
         
         Modify.add(rotation);
         Modify.add(mirror); 
         Modify.add(drawing);
         Modify.add(negative);
         
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
         punch      = new JMenuItem("Punch");
         vintage 	= new JMenuItem("Vintage");
         thickness  = new JMenuItem("Thickness");
         
         blackwhite.addActionListener(this);
         punch.addActionListener(this);
         vintage.addActionListener(this);
         thickness.addActionListener(this);
         
         Filter.add(blackwhite);
         Filter.add(punch);
         Filter.add(vintage);         
         Export.add(thickness);
         
         
   //Adding Menus to Menubar
         
         
         MB.add(FileMenu);
         MB.add(Modify);
         MB.add(Enhance);
         MB.add(Filter);
         MB.add(Export);
         MB.add(Help);
         
 
   //Choosing the specific file from file chooser
       
         
        imagePanel.add(imageLabel, BorderLayout.CENTER);
 	    imagePanel.setLayout(new FlowLayout());
 	  
         
	    FileNameExtensionFilter openFilter;
	    openFilter = new FileNameExtensionFilter("Images", "jpg", "bmp", "jpeg");
	    javaFileChooser.setFileFilter(openFilter);
	    
	
	    
	    
    //Shape of the frame
         
         frame.add(imagePanel);
		 frame.setJMenuBar(MB);
         frame.setSize(600,500);  
         frame.setLayout(null);  
         frame.setVisible(true);
         
          
      }

	  
	  
		@Override
		public void actionPerformed(ActionEvent e)
		{	
			
			
			EditingFeatures edit = new EditingFeatures();			
			
			JMenuItem operation = (JMenuItem) (e.getSource());
			
			if(operation.getText().equals("Open"))
			{
				try
				{
					openFile();
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
			
			else if (operation.getText().equals("Save"))
			{
				//a method to save
			} 
			
			else if (operation.getText().equals("Close"))
			{
				System.exit(0);
			} 
			
			else if (operation.getText().equals("Negative"))
			{
				edit.makeNegative();
			}

									
		}
		
		public void openFile() throws IOException
		{
			
				int returnValue = javaFileChooser.showOpenDialog(javaFileChooser);
				
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{
					
					try{
						
							String filePath = javaFileChooser.getSelectedFile().getAbsolutePath();
						
							bufferedImage 	= ImageIO.read(new File(filePath)); //Make filePath a File
							OriginalImage 	= ImageIO.read(new File(filePath));
						
							System.out.println("Reading Finished");	
						
							DisplayImage();	
						
					    }
						catch (IOException e)
						{
							e.printStackTrace();
						}
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "please select image");
				}
				
		}
		
		public void DisplayImage() {
			
	      JLabel label = new JLabel(new ImageIcon(bufferedImage));
	      frame.add(label);
	      frame.setVisible(true);
//			imageLabel.setIcon(new ImageIcon(image));   //How to display???
	      System.out.println("Displaying finished");

		}
		

		
		

		
}

//Set Image() & Display Image	
//label = new JLabel();
//imgpanel.add(label, BorderLayout.CENTER);
//imgpanel.setLayout(new FlowLayout());
//add(imgpanel);


//How to create submenu

//i4 = new JMenuItem("Item 4");  
//i5 = new JMenuItem("Item 5");       
//submenu  = new JMenu("New");
//submenu.add(i4); 
//submenu.add(i5);       
//edit.add(submenu); 