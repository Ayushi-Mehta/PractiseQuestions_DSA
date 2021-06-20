package DynamicProgramming;

import java.util.Arrays;

public class EditDistance_IMPORTANT {
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "agcfd";
		int[][] storage = new int[s1.length()][s2.length()];
		for (int i = 0; i < storage.length; i++) {
			Arrays.fill(storage[i], -1);
		}
//		System.out.println(editDistanceRecursion(s1, s2));
//		System.out.println(editDistanceRecursionVirtaulIndex(s1, s2, 0, 0));
//		System.out.println(editDistanceTopDownDP(s1, s2, 0, 0, storage));
		System.out.println(editDistanceBottomUpDP(s1, s2));
	}

	public static int editDistanceRecursion(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = editDistanceRecursion(ros1, ros2);
		} else {
			int i = editDistanceRecursion(ros1, s2);// insertion
			int d = editDistanceRecursion(s1, ros2);// deletion
			int r = editDistanceRecursion(ros1, ros2);// replace

			ans = Math.min(i, Math.min(d, r)) + 1;
		}
		return ans;
	}
	// substring function increases time so we break the string virtually to
	// decrease time complexity

	// O(3^(m+n))
	public static int editDistanceRecursionVirtaulIndex(String s1, String s2, int vidx1, int vidx2) {
		if (s1.length() == vidx1 || s2.length() == vidx2) {
			return Math.max(s1.length() - vidx1, s2.length() - vidx2);
		}
		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;

		if (ch1 == ch2) {
			ans = editDistanceRecursionVirtaulIndex(s1, s2, vidx1 + 1, vidx2 + 1);
		} else {
			int i = editDistanceRecursionVirtaulIndex(s1, s2, vidx1 + 1, vidx2);// insertion
			int d = editDistanceRecursionVirtaulIndex(s1, s2, vidx1, vidx2 + 1);// deletion
			int r = editDistanceRecursionVirtaulIndex(s1, s2, vidx1 + 1, vidx2 + 1);// replace

			ans = Math.min(i, Math.min(d, r)) + 1;
		}
		return ans;
	}

	// O(m*n),S(O(m*n)+rec extra space)
	public static int editDistanceTopDownDP(String s1, String s2, int vidx1, int vidx2, int[][] storage) {
		if (s1.length() == vidx1 || s2.length() == vidx2) {
			return Math.max(s1.length() - vidx1, s2.length() - vidx2);
		}
		if (storage[vidx1][vidx2] != -1) {
			return storage[vidx1][vidx2];
		}
		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;

		if (ch1 == ch2) {
			ans = editDistanceTopDownDP(s1, s2, vidx1 + 1, vidx2 + 1, storage);
		} else {
			int i = editDistanceTopDownDP(s1, s2, vidx1 + 1, vidx2, storage);// insertion
			int d = editDistanceTopDownDP(s1, s2, vidx1, vidx2 + 1, storage);// deletion
			int r = editDistanceTopDownDP(s1, s2, vidx1 + 1, vidx2 + 1, storage);// replace

			ans = Math.min(i, Math.min(d, r)) + 1;
		}
		storage[vidx1][vidx2] = ans;
		return ans;
	}

	// O(m*n),S(O(m*n))
	public static int editDistanceBottomUpDP(String s1, String s2) {
		// created 2D array
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];

		// filling:bottom to top and right to left
		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {
				// base case: deletion ops
				if (row == s1.length()) {
					storage[row][col] = s2.length() - col;
				}
				// base case: insertion ops
				else if (col == s2.length()) {
					storage[row][col] = s1.length() - row;
				}
				// you are filling some intermediate cell
				else {
					if (s1.charAt(row) == s2.charAt(col)) {
						storage[row][col] = storage[row + 1][col + 1];
					} else {
						int i = storage[row + 1][col];
						int d = storage[row][col + 1];
						int r = storage[row + 1][col + 1];

						storage[row][col] = Math.min(i, Math.min(d, r)) + 1;
					}
				}
			}
		}

		return storage[0][0];
	}

}
