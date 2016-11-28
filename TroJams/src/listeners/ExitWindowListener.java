package listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import networking.TrojamClient;
//pop-up for when user clicks the red X on a frame
public class ExitWindowListener extends WindowAdapter{

	private JFrame frame;
	private TrojamClient tc;
	
	public ExitWindowListener(JFrame frame, TrojamClient tc) {
		this.frame = frame;
		this.tc = tc;
	}
	
	 public void windowClosing(WindowEvent e) {
//		 int answer = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, AppearanceConstants.exitIcon);
//	     
//		 if (answer == JOptionPane.YES_OPTION){
//			 if 
//			 System.exit(0);
//		 }
		 tc.close();
		 System.exit(0);
	 }

}
