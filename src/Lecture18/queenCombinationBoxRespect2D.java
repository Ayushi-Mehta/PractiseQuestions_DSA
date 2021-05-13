package Lecture18;

public class queenCombinationBoxRespect2D {

	public static void main(String[] args) {
		
			QueenCombBoxRespect2D(new boolean[2][2], 0, 0, 0, 2, "");
			System.out.println("-------------------");
			QueenCombBoxRespect2DRecCall(new boolean[2][2], 0, 0, 0, 2, "");

	}
	public static void QueenCombBoxRespect2D(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
		//write this call first otherwise ans will not be printed and the recursion will return 
		if(qpsf==tq) {//+ve base case
			System.out.println(ans);
			return;
		}
		//manually changing variables
		if(col==board.length) {
			row++;
			col=0;
		}
		if(row==board[0].length) {//-ve base case
			return;
		}
		// queen placed
		board[row][col] = true;// q0 placed in b0
		QueenCombBoxRespect2D(board,row, col + 1, qpsf + 1, tq, ans + "{r"+row+"c" + col+"}");
		board[row][col]=false;//queen removed from there
		
		//queen not placed
		QueenCombBoxRespect2D(board,row, col+1, qpsf, tq, ans);
		
	}
	public static void QueenCombBoxRespect2DRecCall(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
		//write this call first otherwise ans will not be printed and the recursion will return 
		if(qpsf==tq) {//+ve base case
			System.out.println(ans);
			return;
		}
		//extra recursive call
		if(col==board.length) {
			QueenCombBoxRespect2DRecCall(board, row+1, 0, qpsf, tq, ans);
			return;//very imp to write this line here
			//otherwise the code will execute for frames outside the boundary
		}
		if(row==board[0].length) {//-ve base case
			return;
		}
		// queen placed
		board[row][col] = true;// q0 placed in b0
		QueenCombBoxRespect2DRecCall(board,row, col + 1, qpsf + 1, tq, ans + "{r"+row+"c" + col+"}");
		board[row][col]=false;//queen removed from there
		
		//queen not placed
		QueenCombBoxRespect2DRecCall(board,row, col+1, qpsf, tq, ans);
		
	}
}
