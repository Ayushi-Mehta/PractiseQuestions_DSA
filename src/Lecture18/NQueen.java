package Lecture18;

public class NQueen {

	public static void main(String[] args) {
		boolean[][] board=new boolean[4][4];
		Nqueen(board, 0, 0, 0, 4, "");
	}
	public static void Nqueen(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
		// write this call first otherwise ans will not be printed and the recursion
		// will return
		if (qpsf == tq) {// +ve base case
			System.out.println(ans);
 			return;
		}
		// manually changing variables
		if (col == board.length) {
			row++;
			col = 0;
		}
		if (row == board[0].length) {// -ve base case
			return;
		}
		// queen placed only if it is safe
		if (isItSafeToPlaceQueen(board, row, col)) {
			board[row][col] = true;// q0 placed in b0
			Nqueen(board, row+1, 0, qpsf + 1, tq, ans + "{r" + row + "c" + col + "}");
			//saves a lot of extra time as queen cant be placed in the same row ever
			board[row][col] = false;// queen removed from there
		}

		// queen not placed
		Nqueen(board, row, col + 1, qpsf, tq, ans);

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
		//if code reaches here, all directions are safe
		return true;
	}
}
