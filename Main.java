import javax.swing.SwingUtilities;

//Program Launcher (should launch this upon start up)
public class Main {
		
	public static void main(String args[]) {
		
		//Generates thread so as to be able to run the JFrame
		SwingUtilities.invokeLater(new Runnable() {
				
			public void run() {
				new MainFrame();
			}
		});
	}

}
