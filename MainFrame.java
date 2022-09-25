import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//Creates the main JFrame which contains buttons to launch the various sites
public class MainFrame extends JFrame {
	
	//Sets up full screen mode to remove the OS bars
	static GraphicsDevice device = GraphicsEnvironment
	        .getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	public MainFrame() {
		
		super("Selection");
				
		add(CreateImage("youtube.jpg","www.youtube.com"));
		add(CreateImage("netflix.jpeg","www.netflix.com"));
		add(CreateImage("stan.png","www.stan.com.au"));
		add(CreateImage("disney_plus.jpg","www.disneyplus.com"));
		add(CreateImage("prime.png","www.primevideo.com"));
		add(CreateImage("sbs.jpg","www.sbs.com.au/ondemand"));
		add(CreateImage("iview.png","iview.abc.net.au"));
		add(CreateImage("channel9.png","www.9now.com.au"));
		add(CreateImage("channel7.png","7plus.com.au"));
		add(CreateImage("channel10.png","10play.com.au")); 
		add(CreateImage("justwatch.png","www.justwatch.com"));
		add(CreateImage("power.png","ShutDown"));
		
		setLayout(new GridLayout(3,4));
		
		//Launches frame as fullscreen
		//device.setFullScreenWindow(this);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		
		//Non full screen mode for testing purposes
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100, 800,600);
		
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
		
		//Adds an action listener to the button
		LaunchBrowser launch = new LaunchBrowser(webpage);
		btn.addActionListener(launch);
		
		return btn;
		
	}

}
