import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.sun.prism.Image;

public class EditingFeatures extends PhotoEditingWindow
{

	//An image which can be edited

	public EditingFeatures()
	{

	}

	public void makeNegative()
	{
		
		    BufferedImage image = null;
		    File file = null;
		    try{
		      file = new File("C:\\Users\\Md. Alamgir Kabir\\Downloads\\IMG_7946.JPG");  //read image
		      image = ImageIO.read(file);
		    }catch(IOException e){
		      System.out.println(e);
		    }
		    
		    int width = image.getWidth();
		    int height = image.getHeight();	//get image width and height
		    
		    for(int y = 0; y < height; y++)
		    {
		      for(int x = 0; x < width; x++)
		      {
		    	  
		        int pixel = image.getRGB(x,y);
		        int alpha = (pixel>>24) & 0xff;
		        int red	  = (pixel>>16) & 0xff;
		        int green = (pixel>>8)  & 0xff;
		        int blue  =  pixel & 0xff;
		      
		        red   = 255 - red;
		        green = 255 - green;
		        blue  = 255 - blue;
		       
		        pixel = (alpha<<24) | (red<<16) | (green<<8) | blue;  //subtract RGB from 255 //convert to negative
		        image.setRGB(x, y, pixel);
		      }
		    }
		  
		    try
		    {
		      file = new File("C:\\Users\\Md. Alamgir Kabir\\Downloads\\Output.jpg");
		      ImageIO.write(image, "jpg", file);
		    }catch(IOException e)
		    {
		      System.out.println(e);
		    }
		  
		}
		
}
	

//label = new JLabel();
//imgpanel.add(label, BorderLayout.CENTER);
//imgpanel.setLayout(new FlowLayout());
//add(imgpanel);

// FileReader fr = new FileReader("C:\\Users\\pankaj\\Desktop\\test.txt");
// int i;
// while ((i = fr.read()) != -1)
// System.out.print((char) i);

//File outputFile = new File("Image2.jpg");
//File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt");

//BufferedReader br = new BufferedReader(new FileReader(file));
//File file = new File(filePath);

//BufferedReader br = new BufferedReader(new FileReader(file));
//String st;
//while ((st = br.readLine()) != null)
//  System.out.println(st);
//try{
//	
//	FileWriter fw = new FileWriter(outputFile, true);
//	BufferedWriter bw = new BufferedWriter(fw);
//	
//	char[] ch = string.toCharArray();  
//	for(int i=0;i<ch.length;i++){  
//	  
//		bw.append(ch[i]);
//	}  
//	//bw.close();
//	
//  }catch (IOException e){
//		 e.printStackTrace();
//   }
