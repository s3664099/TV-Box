import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class ProcessKill implements KeyListener {
	
	Process pr;
	
	public ProcessKill(Runtime run, String cmd) {
		
		try {
			pr = run.exec(cmd);
			waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void waitFor() {
		try {
			pr.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

		if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
			System.out.println("Hello");
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
