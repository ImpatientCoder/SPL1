package animation;

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

public class CreateAnimation implements ActionListener
{
	JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\Md. Alamgir Kabir\\Documents\\Sample3.jpg"));
	JLabel welcome = new JLabel("WELCOME TO ANIMATION WINDOW");
	
	JPanel panel = new JPanel();
	
	JFileChooser javaFileChooser = new JFileChooser("Enter an Image");
	
	JMenu FileMenu, ModifyMenu;
	JMenuItem open, save, close, animation;
	 
	public Image originalImage; 
	public BufferedImage bufferedImage;

	public CreateAnimation()
	{
		// Default constructor
	}
	
	public void makeFrame()
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("WELCOME TO ANIMATION WINDOW");
		frame.add(panel);
		panel.setLayout(null);
		
		JMenuBar menubar  = new JMenuBar();
		
		FileMenu   	 = new JMenu("File Menu");
		ModifyMenu   = new JMenu("Modify Image");
		
		open = new JMenuItem("Open");
        save = new JMenuItem("Save");  
        close = new JMenuItem("Close");
        animation = new JMenuItem("See Animation");
        
        FileMenu.add(open); 
        FileMenu.add(save); 
        FileMenu.add(close);
        ModifyMenu.add(animation);
        
        open.addActionListener(this);         
        save.addActionListener(this);
        close.addActionListener(this);
        animation.addActionListener(this);
        
        menubar.add(FileMenu);
        menubar.add(ModifyMenu);
        
        welcome.setBounds(160, 50, 300, 20);
        imageLabel.setBounds(300, 250, 300, 300);
        //menubar.setBounds(0, 20, 200, 20); //panel.add(menubar);
        panel.add(welcome);
        panel.add(imageLabel);
        frame.setJMenuBar(menubar); 
        frame.setSize(600,600);  
        frame.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		CreateAnimation CA = new CreateAnimation();
		CA.makeFrame();
	}
	
	
	public void actionPerformed(ActionEvent e)
	{	
		JMenuItem operation = (JMenuItem) (e.getSource());
		
		if (operation.getText().equals("Open"))
		{
			openFile();
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
	
	

	public void displayImage(BufferedImage bufferedImage)
	{
		imageLabel.setBounds(0, 0, 300, 300);
		imageLabel.setIcon(new ImageIcon(bufferedImage));
	}

//	public void displayOriginalImage()
//	{		
//		imageLabel.setIcon(new ImageIcon(originalImage));	
//	}
	
	

} //end of the class
