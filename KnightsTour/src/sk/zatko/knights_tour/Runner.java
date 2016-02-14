package sk.zatko.knights_tour;

import sk.zatko.knights_tour.ui.ResultUserInterface;
import sk.zatko.knights_tour.ui.UserInterface;

/*
 * Runs the application
 * Create GUI and controller objects
 * 
 * @author Jozef Zatko 
 */
public class Runner {

	public static void main(String[] args) {	
		Solver solver = null;
		
		UserInterface gui = new UserInterface();
		ResultUserInterface resultGui = new ResultUserInterface();
		
		new Controller(solver, gui, resultGui);
		
		gui.setVisible(true);
	}
}
