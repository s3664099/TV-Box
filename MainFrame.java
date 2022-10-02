import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//Creates the main JFrame which contains buttons to launch the various sites
public class MainFrame extends JFrame {
	
	//Sets up full screen mode to remove the OS bars
	static GraphicsDevice device = GraphicsEnvironment
	        .getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	//Array to hold the details of each of the buttons. Either launches a website
	//Or something else
	String[][] buttons = {{"youtube.jpg","www.youtube.com"},
		{"netflix.jpeg","www.netflix.com"},
		{"stan.png","www.stan.com.au"},
		{"disney_plus.jpg","www.disneyplus.com"},
		{"prime.png","www.primevideo.com"},
		{"sbs.jpg","www.sbs.com.au/ondemand"},
		{"iview.png","iview.abc.net.au"},
		{"channel9.png","www.9now.com.au"},
		{"channel7.png","7plus.com.au"},
		{"channel10.png","10play.com.au"},
		{"justwatch.png","www.justwatch.com"},
		{"play.png","video"},
		{"folder.png","filesystem"},
		{"power.png","ShutDown"}
	};
	
	//Defines the size of the grid layout
	int width = 3;
	int height = 5;
	
	public MainFrame() {
		
		super("Selection");
		
		//Goes through the buttons and adds them to the grid based on the number
		//of squares on the grid.
		int buttonCount = 0;
		for (int x = 0; x < width*height; x++) {
			
			//Checks if there is an entry, if not adds a 'dead' button.
			if (buttonCount >= buttons.length) {
				
				JButton button = new JButton();
				button.setBackground(Color.black);
				add(button);
				
			} else {
				add(CreateImage(buttons[x][0],buttons[x][1]));
			}
			buttonCount ++;
		}
				
		setLayout(new GridLayout(width,height));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Launches frame as fullscreen
		device.setFullScreenWindow(this);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		
		//Non full screen mode for testing purposes
		//setBounds(100,100, 800,600);
		
		//Activates Panel
		setVisible(true);
		
	}
	
	//Builds the button that appears on the JFrame grids.
	//Takes 2 strings - the location of an icon, and the webpage
	private JButton CreateImage(String icon,String webpage) {
		
		//Generates the icon and adds the icon to the button
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(icon));
		Image image = imageIcon.getImage();
		Image newImg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		//Creates the button
		JButton btn = new JButton(newIcon);
		
		btn.setBackground(Color.black);
		
		//Adds an action listener to the button
		LaunchBrowser launch = new LaunchBrowser(webpage,btn);
		btn.addActionListener(launch);
		
		return btn;
		
	}
}