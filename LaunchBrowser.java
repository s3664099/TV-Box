import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class LaunchBrowser implements ActionListener {

	private String webpage;
	private JButton btn;
	String path = "~/Videos";
	String defaultPlayer = "smplayer";
	String fullScreenOption = "-fullscreen";
	String browser = "firefox";
	String browserOption = "-kiosk";
	
	public LaunchBrowser(String webpage,JButton btn) {
		this.webpage = webpage;
		this.btn = btn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Checks to see if the command is to shutdown the computer or
		//Open the browser at a specific website
		if (webpage == "ShutDown") {
			
			//Calls the shutdown method
			shutDown(e);
			
		} else if (webpage == "video") {
			
			launchVideo();
			
		} else if (webpage == "filesystem") {
			
			//Opens the file system to allow searching for videos
			openFileSystem();
				        
		} else {

			//Opens the website, Firefox, in kiosk mode at selected website
			openWebsite();

		}

	}
	
	//Method that shuts down either computer, or the program
	private void shutDown(ActionEvent e) {
		
		//Checks to see if Ctrl Key has been pressed, and if so kills the program.
		if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
            
			System.exit(0);
			
         } else {
        	            	
        	//Otherwise sets the process to shutdown the computer
 			executeCmd("shutdown");
 			
         }
	}
	
	//Method to launch a video in the default video player
	private void launchVideo() {
		
		//Opens up dialogue box at the set path to choose file to launch
		//https://www.codejava.net/java-se/swing/show-simple-open-file-dialog-using-jfilechooser
		JFileChooser chooser = new JFileChooser(path);

		//Sets the file names that can be used
		//FileNameExtensionFilter filter = new FileNameExtensionFilter(
        //        "JPG & GIF Images", "jpg", "gif");
        //chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {

            String fileName = chooser.getSelectedFile().getAbsolutePath();
            
            //https://stackoverflow.com/questions/33077129/java-runtime-exec-with-white-spaces-on-path-name
            //Launches the video in the default video player
            try {
				new ProcessBuilder(defaultPlayer,fullScreenOption,fileName).start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            	            
        }
		
	}
	
	//Opens browser in kiosk mode at selected website
	private void openWebsite() {
		
		//Disables button
		btn.setEnabled(false);

		//Sets the command to run firefox in kiosk mode
		executeCmd(browser+" "+browserOption+" http://"+webpage);
		
		//Waits 10 seconds and then re-enables button
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btn.setEnabled(true);
	}
	
	private void openFileSystem() {
		
		try {
			new ProcessBuilder("gnome-open",path).start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	//Executes a command
	private void executeCmd(String cmd) {
		
		Runtime run = Runtime.getRuntime();
		try {
			run.exec(cmd);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
