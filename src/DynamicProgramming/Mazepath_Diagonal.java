package DynamicProgramming;

import java.util.Arrays;

public class Mazepath_Diagonal {

	public static void main(String[] args) {
		int n = 2;
		System.out.println(mazepathDiagonalRecursion(0, 0, n, n));
		System.out.println(mazepathDiagonalTopDownDP(0, 0, n, n, new int[n + 1][n + 1]));
		System.out.println(mazepathDiagonalBottomUpDP(n, n));
		System.out.println(mazepathDiagonalBottomUpDP_SpaceEffi(n, n));
	}

	// O(3^(er+ec))
	public static int mazepathDiagonalRecursion(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = mazepathDiagonalRecursion(cr, cc + 1, er, ec);
		int cv = mazepathDiagonalRecursion(cr + 1, cc, er, ec);
		int cd = mazepathDiagonalRecursion(cr + 1, cc + 1, er, ec);

		return ch + cd + cv;
	}

	// O(er*ec)
	public static int mazepathDiagonalTopDownDP(int cr, int cc, int er, int ec, int[][] storage) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		if (storage[cr][cc] != 0) {
			return storage[cr][cc];
		}

		int ch = mazepathDiagonalTopDownDP(cr, cc + 1, er, ec, storage);
		int cv = mazepathDiagonalTopDownDP(cr + 1, cc, er, ec, storage);
		int cd = mazepathDiagonalTopDownDP(cr + 1, cc + 1, er, ec, storage);

		storage[cr][cc] = ch + cd + cv;
		return storage[cr][cc];
	}

	//O(er*ec),S(O(er*ec))
	public static int mazepathDiagonalBottomUpDP(int er, int ec) {
		int[][] storage = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er && col == ec) {
					storage[row][col] = 1;
				} else {
					storage[row][col] = storage[row][col + 1] + storage[row + 1][col] + storage[row + 1][col + 1];
				}
			}
		}
		return storage[0][0];
	}
	
	
	public static int mazepathDiagonalBottomUpDP_SpaceEffi(int er, int ec) {
		int[] storage = new int[ec + 1];//row to be overlapped
		
		Arrays.fill(storage, 1);
		
		int diagonal=0;

		for (int slide = er-1; slide >= 0; slide--) {
			for(int col=ec;col>=0;col++) {
				if(col==ec) {
					storage[col]=1;
					diagonal=1;
				}else {
					int val=storage[col]+storage[col+1]+diagonal;
					diagonal=storage[col];
					storage[col]=val;
				}
			}
		}
		return storage[0];
	}
	
}
