package animationPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation extends JPanel implements ActionListener
{
	
	Timer timer;
	int delay=9;
	
	int x = 50,y = 70,directionX=-1,directionY=1;
	
	//int x = 0, y = 0;

	
	BufferedImage image;
	boolean seeAnimation=false;
	
	JFileChooser javaFileChooser = new JFileChooser("Enter an Image");
	
	JMenu FileMenu, ModifyMenu;
	JMenuItem open, save, close, animation;
	
	public Animation(JFrame frame) throws IOException
	{
		
		timer=new Timer(delay,this);
		timer.start();
		
		image=ImageIO.read(getClass().getResourceAsStream("/Atik&Me.png"));
		
		JMenuBar menubar  = new JMenuBar();
		FileMenu   	 = new JMenu("File Menu");
		ModifyMenu   = new JMenu("Modify Image");
		
		open = new JMenuItem("Open");
        save = new JMenuItem("Save");  
        close = new JMenuItem("Close");
        animation = new JMenuItem("See Animation");
        
        animation.addActionListener(new ActionListener()
        {      	
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				seeAnimation=true;	
			}
        });
        
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
              
        frame.setJMenuBar(menubar);	
	}
	
	
	public void paintComponent(Graphics g)
	{	
		g.setColor(Color.red);
		g.fillRect(0,0,600,600);
		
		g.setColor(Color.red);

		g.drawImage(image,x,y,300,300,null);		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{	
		if(seeAnimation)
		{
				//System.out.println("Animation");
				
				x+=directionX;
				y+=directionY;
				
				if(x<=0||x>=300)
				{	
					directionX*=-1;
				}
				if(y<=0||y>=300)
				{	
					directionY*=-1;
				}
				
					
			
		}
		
		repaint();	
	}

	
	
	
}//end of the class
