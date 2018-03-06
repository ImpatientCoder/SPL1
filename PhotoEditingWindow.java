import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PhotoEditingWindow implements ActionListener
{
	
	
	  JMenu FileMenu, Modify, Enhance, Filter, Export, Help;
	  
	  JMenuItem open, save, close;
	  JMenuItem rotation, mirror, drawing, negative;
	  JMenuItem contrast, curves, sharpness,  edges;
	  JMenuItem blackwhite, punch, vintage, thickness;

	  
	  JFileChooser javaFileChooser = new JFileChooser("Enter an Image");
	
	  
	  public PhotoEditingWindow()
	  {
		  createMenubar();
	  }	

	  
	  
	  public void createMenubar()
      { 
		  
    	 JFrame frame = new JFrame("Photo Editor");  
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
         
         
	    FileNameExtensionFilter openFilter;
	    openFilter = new FileNameExtensionFilter("Images", "jpg", "bmp", "jpeg");
	    javaFileChooser.setFileFilter(openFilter);       
	    
    //Shape of the frame
         
         
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
				try {
					edit.openFile();
				 } catch (IOException e1) {
					// TODO Auto-generated catch block
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


			
									
		}
		

		
//      Set Image() & Display Image	

//		How to create submenu
		
//      i4 = new JMenuItem("Item 4");  
//      i5 = new JMenuItem("Item 5");       
//      submenu  = new JMenu("New");
//      submenu.add(i4); 
//      submenu.add(i5);       
//      edit.add(submenu); 
		
}