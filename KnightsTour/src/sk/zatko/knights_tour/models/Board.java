package sk.zatko.knights_tour.models;

/*
 * Model of chess board
 * 
 * @author Jozef Zatko
 */
public class Board {
	
	private int[][] matrix;
	private int matrixSize;
	
	public Board(int matrixSize, int xStart, int yStart) {
		
		this.matrix = new int[matrixSize][matrixSize];
		this.matrixSize = matrixSize;
		
		matrix[xStart][yStart] = 1;
	}
	
	public Board(Board b) {
		
		this.matrix = new int[b.getMatrixSize()][b.getMatrixSize()];
		this.matrixSize = b.getMatrixSize();
		
		for(int i=0; i<matrixSize; i++) {
			for(int j=0; j<matrixSize; j++) {
				matrix[j][i] = b.getMatrix(j, i);
			}
		}
	}
	
	/*
	 * Sumarize of possible moves from position
	 */
	public int countOfPossibleMoves(int x, int y) {
		
		int count = 0;
		
		if(isReachable1(x,y)) { count++; }
		if(isReachable2(x,y)) { count++; }
		if(isReachable3(x,y)) { count++; }
		if(isReachable4(x,y)) { count++; }
		if(isReachable5(x,y)) { count++; }
		if(isReachable6(x,y)) { count++; }
		if(isReachable7(x,y)) { count++; }
		if(isReachable8(x,y)) { count++; }
				
		return count;
	}
	
	// move no.1 --> x-1, y-2
	public boolean isReachable1(int x, int y) {
		
		if(x-1>=0 && y-2>=0) { return true;
		}
		return false;
	}
	
	// move no.2 --> x+1, y-2
	public boolean isReachable2(int x, int y) {
			
		if(x+1<matrixSize && y-2>=0) {
			return true;
		}
		return false;
	}
	
	// move no.3 --> x+2, y-1
	public boolean isReachable3(int x, int y) {
			
		if(x+2<matrixSize && y-1>=0) {
			return true;
		}
		return false;
	}
		
	// move no.4 --> x+2, y+1
	public boolean isReachable4(int x, int y) {
			
		if(x+2<matrixSize && y+1<matrixSize) {
			return true;
		}
		return false;
	}
		
	// move no.5 --> x+1, y+2
	public boolean isReachable5(int x, int y) {
			
		if(x+1<matrixSize && y+2<matrixSize) {
			return true;
		}
		return false;
	}
		
	// move no.6 --> x-1, y+2
	public boolean isReachable6(int x, int y) {
			
		if(x-1>=0 && y+2<matrixSize) {
			return true;
		}
		return false;
	}	
		
	// move no.7 --> x-2, y+1
	public boolean isReachable7(int x, int y) {
			
		if(x-2>=0 && y+1<matrixSize) {
			return true;
		}
		return false;
	}
		
	// move no.8 --> x-2, y-1
	public boolean isReachable8(int x, int y) {
			
		if(x-2>=0 && y-1>=0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		
		String s = "";
		
		for(int i=0; i<matrixSize; i++) {
			for(int j=0; j<matrixSize; j++) {
				s = s + String.valueOf(matrix[j][i]) + "	";
			}
			s = s + "\n";
		}	
		return s;
	}
	
	public int getMatrixSize() {
		return this.matrixSize;
	}

	public int getSize() {
		return matrixSize*matrixSize;
	}
	
	protected void addPosition(int x, int y) {
		matrix[x][y] = 1;
	}
	
	public void setMatrix(int x, int y, int n) {
		matrix[x][y] = n;
	}
	
	public int getMatrix(int x, int y) {
		return matrix[x][y];
	}
}
