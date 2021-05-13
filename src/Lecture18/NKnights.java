package Lecture18;

public class NKnights {
	static int count = 0;

	public static void main(String[] args) {
		boolean[][] board = new boolean[3][3];
		nKnights(board, 0, 0, 0, board.length, "");
	}

	public static void nKnights(boolean[][] board, int row, int col, int kpsf, int tk, String ans) {
		if (kpsf == tk) {// +ve base case
			System.out.println(++count + "." + ans);
			return;
		}

		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length) {// -ve base case
			return;
		}

		// place
		if (isItSafeToPlaceKnight(board, row, col)) {
			board[row][col] = true;
			nKnights(board, row, col + 1, kpsf + 1, tk, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		// not placed
		nKnights(board, row, col + 1, kpsf, tk, ans);

	}

	public static void NKnightsKill(boolean[][] board, int row, int col, int kpsf, int tk, String ans) {
		if (kpsf == tk) {// +ve base case
			System.out.println(++count + "." + ans);
			return;
		}

		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length) {// -ve base case
			return;
		}

		// place
		board[row][col] = true;
		NKnightsKill(board, row, col + 1, kpsf + 1, tk, ans + "{" + row + "-" + col + "}");
		board[row][col] = false;

		// not placed
		NKnightsKill(board, row, col + 1, kpsf, tk, ans);

	}

	public static boolean isItSafeToPlaceKnight(boolean[][] board, int row, int col) {
		int[] rowArr = { -1, -2, -2, -1 };
		int[] colArr = { 2, 1, -1, -2 };

		for (int i = 0; i < 4; i++) {
			int r = row + rowArr[i];
			int c = col + colArr[i];

			if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
				// inside the board boundaries
				if (board[r][c]) {
					return false;// that there is another knight sitting there so dont place here
				}
			}
		}
		return true;

	}
}
