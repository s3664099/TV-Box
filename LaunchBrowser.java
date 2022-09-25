import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
			//Sets the command to shutdown the computer
			cmd = "poweroff";
			
		} else {

			//Sets the command to run firefox in kiosk mode
			cmd = "firefox -kiosk http://"+webpage;
		}
		
		
		Runtime run = Runtime.getRuntime();
		ProcessKill pr = new ProcessKill(run,cmd);
	}
	
	public boolean getProcessRunning() {
		return processRunning;
	}
	
	public void setProcessRunning() {
		processRunning = false;
	}
	
	public void stopProcess() {
		pr.destroy();
	}

}