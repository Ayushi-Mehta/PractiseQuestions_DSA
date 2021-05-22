package DynamicProgramming;

import java.util.Arrays;

public class Mazepath {

	public static void main(String[] args) {
		int n = 20;
		// System.out.println(mazepathRecursion(0, 0, n, n));
		// System.out.println(mazepathTopDownDP(0, 0, n, n, new int[n + 1][n + 1]));
		//System.out.println(mazepathBottomUpDP(n, n));
		System.out.println(mazepathBottomUpDP_SpaceEffi(n, n));
	}

	public static int mazepathRecursion(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		int ch = mazepathRecursion(cr, cc + 1, er, ec);
		int cv = mazepathRecursion(cr + 1, cc, er, ec);

		return ch + cv;
	}

	// O(er*ec),S(O(er*ec + extra rec space))
	public static int mazepathTopDownDP(int cr, int cc, int er, int ec, int[][] storage) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		if (storage[cr][cc] != 0) {
			return storage[cr][cc];
		}
		int ch = mazepathTopDownDP(cr, cc + 1, er, ec, storage);
		int cv = mazepathTopDownDP(cr + 1, cc, er, ec, storage);

		storage[cr][cc] = ch + cv;

		return storage[cr][cc];
	}

	// O(er*ec),S(O(er*ec))
	public static int mazepathBottomUpDP(int er, int ec) {
		int[][] storage = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er && col == ec) {
					storage[row][col] = 1;
				} else {
					storage[row][col] = storage[row][col + 1] + storage[row + 1][col];
				}
			}
		}

		return storage[0][0];
	}

	public static int mazepathBottomUpDP_SpaceEffi(int er, int ec) {
		int[] storage = new int[ec + 1];

		Arrays.fill(storage, 1);
		for (int slide = er - 1; slide >= 0; slide--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					storage[col] = 1;
				} else {
					storage[col] = storage[col] + storage[col + 1];
				}
			}
		}

		return storage[0];
	}

}
