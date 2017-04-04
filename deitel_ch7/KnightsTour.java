public class KnightsTour {
	
	private static int[][] board = new int[8][8];
	private final static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
	private final static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
	private static int currentRow = 7;
	private static int currentCol = 0;
	private static int counter = 0;
	private static int bestMove;
	
	public static void main(String[] args) {
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				board[i][j] = 0;
			}
		}
		while (counter <= 64){
			bestMove = 8;
			for (int i = 0; i < 8; i++){
				if (validMove(i, currentRow, currentCol)){
					if (accessibility(currentRow + horizontal[i], currentCol + vertical[i]) < bestMove){
						bestMove = i;
					}
				}
			}
			if (bestMove == 8){
				break;
			}
			currentRow += vertical[bestMove];
			currentCol += horizontal[bestMove];
			counter++;
			board[currentRow][currentCol] = counter;
		} 
		displayBoard();
		System.out.printf("Terminated at: %d", counter);
	}
	
	public static void displayBoard(){
		for (int row = 0; row < board.length; row++){
			for (int col = 0; col <board[0].length; col++){
				if (board[row][col] != 0){
					System.out.printf("%2d ", board[row][col]);
				}
				else {
					System.out.printf("%2d ", board[row][col]);
				}
			}
			System.out.println();
		}
	}
	
	public static boolean validMove(int move, int row, int col){
		row += vertical[move];
		col += horizontal[move];
		if (row > 7 || row < 0 || col > 7 || col < 0){
			return false;
		}
		else if(board[row][col] != 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static int accessibility(int row, int col){
		int accessibility = 0;
		for (int i = 0; i < 8; i++){
			if (validMove(i, row, col)){
				accessibility++;
			}
		}
		return accessibility;
		
	}

}
