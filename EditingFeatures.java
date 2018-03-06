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
	
	String  filePath = null;
	
//	BufferedImage image;
//	BufferedImage bufferImage;
	
	
	public EditingFeatures()
	{

	}

	
	public void openFile() throws IOException
	{
		
			int returnValue = javaFileChooser.showOpenDialog(javaFileChooser);
			
			if (returnValue == JFileChooser.APPROVE_OPTION)
			{
				
				filePath = javaFileChooser.getSelectedFile().getAbsolutePath();
				
				File imagefile = new File("ImageFile.jpg");
				
				File file = new File(filePath);
				BufferedReader br = new BufferedReader(new FileReader(file));

				String string;
				while ((string = br.readLine()) != null)
				{	
				  System.out.println(string);
				
//				FileReader fr = new FileReader(filePath);
//				 int i;
//				 while ((i = fr.read()) != -1) {
//				 System.out.print((char) i);
				 
				 
					try{
						
						FileWriter fw = new FileWriter(imagefile, true);
						BufferedWriter bw = new BufferedWriter(fw);
						
						char[] ch = string.toCharArray();  
						for(int i=0;i<ch.length;i++){  
						  
							bw.append(ch[i]);
						}  
						//bw.close();
					
						
						
					  }catch (IOException e){
							 e.printStackTrace();
					   }
				 

				 }

			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "please select image");
			}
			
	}
	

}

// FileReader fr = new FileReader("C:\\Users\\pankaj\\Desktop\\test.txt");
// int i;
// while ((i = fr.read()) != -1)
// System.out.print((char) i);

//File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt");
//BufferedReader br = new BufferedReader(new FileReader(file));

//String st;
//while ((st = br.readLine()) != null)
//  System.out.println(st);