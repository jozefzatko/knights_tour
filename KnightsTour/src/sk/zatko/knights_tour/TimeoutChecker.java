package sk.zatko.knights_tour;

import sk.zatko.knights_tour.ui.ResultUserInterface;
import sk.zatko.knights_tour.ui.UserInterface;

/*
 * Handle Solver loop timeout
 * 
 * @author Jozef Zatko 
 */
public class TimeoutChecker implements Runnable {

	private int timeoutLimit;
	private ResultUserInterface resultGui;
	private UserInterface gui;
	private Thread solverThread;
	
	TimeoutChecker(int limit, UserInterface gui, ResultUserInterface resultGui, Thread solverThread) {
		
		this.timeoutLimit = limit;
		this.gui = gui;
		this.resultGui = resultGui;
		this.solverThread = solverThread;
	}
	
	/*
	 * Stops solver tread after timeout limit
	 */
	@SuppressWarnings("deprecation")
	public void run() {
		
		try {
			Thread.sleep(this.timeoutLimit);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(gui.getBtnStartStop().getText().equals("STOP")) {
			
			solverThread.stop();
			
			gui.getProgressBar().setIndeterminate(false);
			gui.getProgressBar().setStringPainted(false);
			gui.getBtnStartStop().setText("START");
			
			resultGui.setVisible(true);
			resultGui.getTextArea().setText("Timeout: " + this.timeoutLimit + " ms.");
		}

		Thread.currentThread().stop();
	}
}
