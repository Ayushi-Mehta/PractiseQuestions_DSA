package Lecture18;

public class queenCombBoxRespect {

	public static void main(String[] args) {
		QueenCombBoxRespect(new boolean[4], 0, 0, 2, "");
	}

	// qpsf-queens placed so far
	// tq-total queens
	public static void QueenCombBoxRespect(boolean[] board, int col, int qpsf, int tq, String ans) {
		//write this call first otherwise ans will not be printed and the recursion will return 
		if(qpsf==tq) {//+ve base case
			System.out.println(ans);
			return;
		}
		if(col==board.length) {//-ve base case
			return;
		}
		// queen placed
		board[col] = true;// q0 placed in b0
		QueenCombBoxRespect(board, col + 1, qpsf + 1, tq, ans + "b" + col);
		board[col]=false;
		
		//queen not placed
		QueenCombBoxRespect(board, col+1, qpsf, tq, ans);
		
	}
}
