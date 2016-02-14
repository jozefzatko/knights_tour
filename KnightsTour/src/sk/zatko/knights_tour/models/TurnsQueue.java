package sk.zatko.knights_tour.models;

/*
 * Model of TurnsQueue
 * 
 * @author Jozef Zatko
 */
public class TurnsQueue {

	private int queue[][];
	
	public TurnsQueue() {
		this.queue = new int[8][4];
		
		for(int i=0; i<8; i++) {
			this.queue[i][3] = -1;
		}
	}
	
	/*
	 * Adds move into queue
	 */
	public void addToQueue(int moveNumber, int x, int y, int possibleMoves) {
		
		for(int i=0; i<8; i++) {
			
			if(this.queue[i][3] == -1) {
				
				this.queue[i][0] = moveNumber;
				this.queue[i][1] = x;
				this.queue[i][2] = y;
				this.queue[i][3] = possibleMoves;
				
				return;
			}
		}
	}
	
	/*
	 * Insert sort of TurnsQueue
	 */
	public void sort() {
			
		int index;
		int temp[] = new int[4];
		
		for (int i=1; i<8; i++) {
			
			index = i;
			
			while (index > 0 && this.queue[index][3] < this.queue[index-1][3]) {
				
				temp = this.queue[index];
				this.queue[index] = this.queue[index-1];
				this.queue[index-1] = temp;
			}
		}
	}

	public int[][] getQueue() {
		return queue;
	}
	
	public int getValue(int x, int y) {
		return queue[x][y];
	}
}
