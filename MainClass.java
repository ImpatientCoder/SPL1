package animationPackage;

import java.io.IOException;

import javax.swing.JFrame;

public class MainClass {
	
	public static void main(String[] args) throws IOException
	{	
		JFrame frame=new JFrame("Animation Frame");
		Animation animation=new Animation(frame);
		
		frame.setBounds(0,0,600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.add(animation);		
		frame.setVisible(true);
	}

}
