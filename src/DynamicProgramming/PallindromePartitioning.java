package HardDifficulty;

import java.util.Arrays;

public class PallindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abacd";
		System.out.println(pallindromePartitioningRecursion(s, 0, s.length() - 1));
		int[][] storage = new int[s.length()][s.length()];
		for (int i = 0; i < storage.length; i++) {
			Arrays.fill(storage[i], -1);
			// ARRAYS.FILL IS ONLY FOR 1D ARRAY SO WRITTEN LIKE THIS!!!
		}
		System.out.println(pallindromePartitioningTopDownDP(s, 0, s.length() - 1, storage));
	}

	public static int pallindromePartitioningRecursion(String s, int si, int ei) {

		if (isPallindrome(s, si, ei)) {
			return 0;
		}
		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {
			int fp = pallindromePartitioningRecursion(s, si, k);
			int sp = pallindromePartitioningRecursion(s, k + 1, ei);

			int total = fp + sp + 1;

			if (total < min) {
				min = total;
			}
		}
		return min;
	}

	public static boolean isPallindrome(String s, int si, int ei) {
		int l = si;
		int r = ei;

		while (l < r) {
			if (s.charAt(si) != s.charAt(ei)) {
				return false;
			}
			l++;
			r--;
		}
		return true;

	}

	public static int pallindromePartitioningTopDownDP(String s, int si, int ei, int[][] storage) {

		if (isPallindrome(s, si, ei)) {
			return 0;
		}
		if (storage[si][ei] != -1) {
			return storage[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {
			int fp = pallindromePartitioningTopDownDP(s, si, k, storage);
			int sp = pallindromePartitioningTopDownDP(s, k + 1, ei, storage);

			int total = fp + sp + 1;

			if (total < min) {
				min = total;
			}
		}

		storage[si][ei] = min;
		return min;
	}

	public static int pallindromePartitioningBottomUpDP(String s) {

		boolean[][] isStringPallindrome = isPallindromeBottomUpDP(s);
		int[][] storage = new int[s.length()][s.length()];
		int n = s.length() - 1;
		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				if (isStringPallindrome[si][ei]) {
					storage[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;

					for (int k = si; k <= ei - 1; k++) {
						int fp = storage[si][k];
						int sp = storage[k + 1][ei];

						int total = fp + sp + 1;

						if (total < min) {
							min = total;
						}
					}

					storage[si][ei] = min;
				}
			}
		}
		return storage[0][n - 1];
	}

	public static boolean[][] isPallindromeBottomUpDP(String s) {
		boolean[][] isStringPallindrome = new boolean[s.length()][s.length()];

		for (int i = 0; i < isStringPallindrome.length; i++) {
			Arrays.fill(isStringPallindrome[i], true);
		}
		for (int row = s.length() - 1; row >= 0; row--) {
			for (int col = row + 1; col < s.length(); col++) {
				if (s.charAt(row) == s.charAt(col)) {
					isStringPallindrome[row][col] = isStringPallindrome[row + 1][col - 1];
				} else {
					isStringPallindrome[row][col] = false;
				}
			}
		}

		return isStringPallindrome;
	}

}
