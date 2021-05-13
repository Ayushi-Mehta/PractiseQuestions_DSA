package Lecture18;

public class NQueen2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = new boolean[4][4];
		nQueen2(board, 0, 0, board.length, "");
		System.out.println("---------------------");
		kQueen(board, 0, 0, 3, "");
	}

	static int count = 0;
	static int count1 = 0;
	
	//total queens(n) have to be equal to board.length
	public static void nQueen2(boolean[][] board, int row, int qpsf, int tq, String ans) {
		// col==board[0]length
		if (qpsf == tq) {
			System.out.println(++count1 + "." + ans);
			return;
		}
		if (row == board.length) {
			return;
		}

		for (int col = 0; col < board[0].length; col++) {
			//one queen per row is mandatory
			if (isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				nQueen2(board, row + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
				board[row][col] = false;// undo
			}
			
			
		}
		
		
	}
	
		////total queens(k) need not be equal to board.length
	public static void kQueen(boolean[][] board, int row, int qpsf, int tq, String ans) {
		// col==board[0]length
		if (qpsf == tq) {
			System.out.println(++count + "." + ans);
			return;
		}
		if (row == board.length) {
			return;
		}

		for (int col = 0; col < board[0].length; col++) {
			//one queen per row is mandatory
			if (isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				kQueen(board, row + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
				board[row][col] = false;// undo
			}
			
			
		}
		//not placed
				kQueen(board, row+1, qpsf, tq, ans);
				//ie the queen decided not to sit in any of those rows

	}

	public static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {
		// vertically upward
		int r = row - 1;
		int c = col;

		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
		}

		// horizontally left
		r = row;
		c = col - 1;

		while (c >= 0) {
			if (board[r][c]) {
				return false;
			}
			c--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c++;
		}
		
		/*
		 * we are not doing all these four movements downwards because
		 * according to our code, there are no queens sitting there since we 
		 * haven't placed them there
		 * 
		 */
		// if code reaches here, all directions are safe
		return true;
	}
}
