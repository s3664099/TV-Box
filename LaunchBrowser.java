import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LaunchBrowser implements ActionListener {

	private Process pr;
	private String webpage;
	private Boolean processRunning;
	private String cmd;
	private Runtime run;
	
	public LaunchBrowser(String webpage) {
		this.webpage = webpage;
		this.processRunning = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Checks to see if the command is to shutdown the computer or
		//Open the browser at a specific website
		if (webpage == "ShutDown") {

			//Checks to see if Ctrl Key has been pressed, and if so kills the program.
			if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                System.exit(0);;
             } else {
            	 
            	//Otherwise sets the process to shutdown the computer
     			executeCmd("Close");
             }
			
		} else {

			//Sets the command to run firefox in kiosk mode
			executeCmd("firefox -kiosk http://"+webpage);
		}
		

	}
	
	//Executes a command
	private void executeCmd(String cmd) {
		
		Runtime run = Runtime.getRuntime();
		try {
			pr = run.exec(cmd);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
