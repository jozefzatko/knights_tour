package sk.zatko.knights_tour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sk.zatko.knights_tour.models.Board;
import sk.zatko.knights_tour.ui.ResultUserInterface;
import sk.zatko.knights_tour.ui.UserInterface;

/*
 * Application Controller
 * 
 * Handle GUI Listeners
 * Starts and stops Solver threads
 * 
 * @author Jozef Zatko
 */
public class Controller {
	
	private Solver solver;
	private Thread solverThread;
	private UserInterface gui;
	private ResultUserInterface resultGui;
	
	
	/*
	 * Controller constructor - initialize GUI attributes and listeners
	 */
	public Controller(Solver solver, UserInterface gui, ResultUserInterface resultGui) {
		
		this.solver = solver;
		this.gui = gui;
		this.resultGui = resultGui;
		
		this.gui.getBtnStartStop().addActionListener(new StartStopListener());
		this.gui.getBtnReset().addActionListener(new ResetListener());
	}

	/*
	 * Start/Stop button listener
	 */
	class StartStopListener implements ActionListener {
		
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			
			if(gui.getBtnStartStop().getText().equals("START")) {
				
				gui.getBtnStartStop().setText("STOP");
				
				// get data from gui
				String comboBoxString 	= gui.getBoardSizeComboBox().getSelectedItem().toString();
				int boardSize 			= Integer.parseInt(comboBoxString.substring(0, comboBoxString.indexOf(" ")));
				int xStartPosition 		= (Integer)gui.getXStartPositionSpinner().getValue();
				int yStartPosition 		= (Integer)gui.getYStartPositionSpinner().getValue();
				int timeLimit 			= Integer.parseInt(gui.getTimeLimitTextField().getText());

				long startTime = System.currentTimeMillis();
				
				Board board = new Board(boardSize, xStartPosition-1, yStartPosition-1);
				
				solver = new Solver(board, gui, resultGui, xStartPosition-1, yStartPosition-1, startTime);
				solverThread = new Thread(solver);
				solverThread.start();	
				
				TimeoutChecker timeoutChecker = new TimeoutChecker(timeLimit, gui, resultGui, solverThread);
				Thread timeoutCheckerThread = new Thread(timeoutChecker);
				timeoutCheckerThread.start();
			}
			
			else {
				gui.getBtnStartStop().setText("START");
				
				if (solverThread != null) {	
					solverThread.stop();
				}
				
				gui.getProgressBar().setIndeterminate(false);
				gui.getProgressBar().setStringPainted(false);
			}	
		}
	}
	
	/*
	 * Reset button listener
	 */
	class ResetListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			gui.getTimeLimitTextField().setText("60000");
			resultGui.getTextArea().setText("");
		}
	}
}
