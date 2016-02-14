package sk.zatko.knights_tour;

import sk.zatko.knights_tour.models.Board;
import sk.zatko.knights_tour.models.TurnsQueue;
import sk.zatko.knights_tour.ui.ResultUserInterface;
import sk.zatko.knights_tour.ui.UserInterface;

/*
 * Class of Knight's tour solver
 * 
 * @author Jozef Zatko
 */
public class Solver implements Runnable {

	private Board board;
	private UserInterface gui;;
	private ResultUserInterface resultFrame;
	
	private int xStart, yStart;
	
	private long startTime;
	private boolean quit;
	
	public Solver(Board board, UserInterface gui, ResultUserInterface resultFrame, int xStart, int yStart, long tStart) {
		
		this.board = board;
		this.gui = gui;
		this.resultFrame = resultFrame;
		this.xStart = xStart;
		this.yStart = yStart;
		
		this.startTime = tStart;
		this.quit = false;
	}
	
	/*
	 * Solve Knight's tour problem on board
	 */
	private void solve(Board board, int x, int y, int step) {
		
		board.setMatrix(x, y, step);
		
		TurnsQueue queue = new TurnsQueue();
		
		// if last step
		if(step == board.getSize()) {
			
			this.quit = true;
			this.board = board;
			
			int totalTime = (int) (System.currentTimeMillis() - this.startTime);
			
			gui.getProgressBar().setIndeterminate(false);
			gui.getProgressBar().setStringPainted(false);
			gui.getBtnStartStop().setText("START");
			
			resultFrame.setVisible(true);
			resultFrame.getTextArea().setText(board.toString());
			resultFrame.getTextArea().append("\n\nTime: " + totalTime + " ms.");
			
			return;
		}
		
		if(quit) {
			return;
		}
		
		step++;
		queue = fillQueue(x,y,board);
		
		// no more possible moves
		if(queue.getValue(7, 3) == -1) {
			return;
		}	
		
		for(int i=0; i<8; i++) {
			
			if(queue.getValue(i, 3) != -1) {
				Board b = new Board(board);
				solve(b, queue.getValue(i, 1), queue.getValue(i, 2), step);
			}
		}

		return;		
	}
	
	/*
	 * Runs solve function in a thread
	 */
	public void run() {
		
		gui.getProgressBar().setIndeterminate(true);	
		
		solve(board, xStart, yStart, 1);
	}
	
	/*
	 * Adds all possible moves into queue and sorts
	 * it according to count of possible moves
	 */
	protected TurnsQueue fillQueue(int x, int y, Board board) {
		
		TurnsQueue queue = new TurnsQueue();
		
		// move no.1 --> x-1, y-2
		if(board.isReachable1(x, y) && (board.getMatrix(x-1, y-2) == 0)) {
			
			queue.addToQueue(1, x-1, y-2, board.countOfPossibleMoves(x-1, y-2));
		}
		
		// move no.2 --> x+1, y-2
		if(board.isReachable2(x, y) && (board.getMatrix(x+1, y-2) == 0)) {	
			
			queue.addToQueue(2, x+1, y-2, board.countOfPossibleMoves(x+1, y-2));
		}
		
		// move no.3 --> x+2, y-1
		if(board.isReachable3(x, y) && (board.getMatrix(x+2, y-1) == 0)) {
			
			queue.addToQueue(3, x+2, y-1, board.countOfPossibleMoves(x+2, y-1));
		}
		
		// move no.4 --> x+2, y+1
		if(board.isReachable4(x, y) && (board.getMatrix(x+2, y+1) == 0)) {

			queue.addToQueue(4, x+2, y+1, board.countOfPossibleMoves(x+2, y+1));
		}
		
		// move no.5 --> x+1, y+2
		if(board.isReachable5(x, y) && (board.getMatrix(x+1, y+2) == 0)) {	
			
			queue.addToQueue(5, x+1, y+2, board.countOfPossibleMoves(x+1, y+2));
		}
		
		// move no.6 --> x-1, y+2
		if(board.isReachable6(x, y) && (board.getMatrix(x-1, y+2) == 0)) {
			
			queue.addToQueue(6, x-1, y+2, board.countOfPossibleMoves(x-1, y+2));
		}
		
		// move no.7 --> x-2, y+1
		if(board.isReachable7(x, y) && (board.getMatrix(x-2, y+1) == 0)) {
			
			queue.addToQueue(7, x-2, y+1, board.countOfPossibleMoves(x-2, y+1));
		}
		
		// move no.8 --> x-2, y-1
		if(board.isReachable8(x, y) && (board.getMatrix(x-2, y-1)) == 0) {
			
			queue.addToQueue(8, x-2, y-1, board.countOfPossibleMoves(x-2, y-1));
		}
		
		queue.sort();
		
		return queue;
	}
}
