package DynamicProgramming;

public class WildcardPatternMatching_IMPORTANT {

	public static void main(String[] args) {
		String src = "abcdef";
		String pat = "a?********";
		System.out.println(wildcardMatchingRecursion(src, pat));
		System.out.println(wildcardMatchingVirtual(src, pat, 0, 0));
		System.out.println(wildcardMatchingTopDownDP(src, pat, 0, 0, new int[src.length()][pat.length()]));
		System.out.println(wildcardMatchingBottomUpDP(src, pat));
	}

	public static boolean wildcardMatchingRecursion(String src, String pat) {
		// base case
		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}
		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}
		if (src.length() == 0 & pat.length() != 0) {
			// ' ' and '****'
			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);

		String ros = src.substring(1);
		String rop = pat.substring(1);

		boolean ans;
		if (chp == chs || chp == '?') {
			ans = wildcardMatchingRecursion(ros, rop);
		} else if (chp == '*') {
			// blank
			boolean blank = wildcardMatchingRecursion(src, rop);
			// multiple
			boolean multiple = wildcardMatchingRecursion(ros, pat);

			ans = blank || multiple;
		} else {
			// first character notmatching
			ans = false;
		}
		return ans;
	}

	// substring is O(n) so we break the strings virtually
	public static boolean wildcardMatchingVirtual(String src, String pat, int svidx, int pvidx) {
		// base case
		if (src.length() == svidx && pat.length() == pvidx) {
			return true;
		}
		if (src.length() != svidx && pat.length() == pvidx) {
			return false;
		}
		if (src.length() == svidx & pat.length() != pvidx) {
			// ' ' and '****'
			for (int i = pvidx; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}

		char chs = src.charAt(svidx);
		char chp = pat.charAt(pvidx);

		boolean ans;
		if (chp == chs || chp == '?') {
			ans = wildcardMatchingVirtual(src, pat, svidx + 1, pvidx + 1);
		} else if (chp == '*') {
			// blank
			boolean blank = wildcardMatchingVirtual(src, pat, svidx, pvidx + 1);
			// multiple
			boolean multiple = wildcardMatchingVirtual(src, pat, svidx + 1, pvidx);

			ans = blank || multiple;
		} else {
			// first character notmatching
			ans = false;
		}
		return ans;
	}

	// 0->result is not yet computed
	// 1->false
	// 2->true
	public static boolean wildcardMatchingTopDownDP(String src, String pat, int svidx, int pvidx, int[][] storage) {
		// base case
		if (src.length() == svidx && pat.length() == pvidx) {
			return true;
		}
		if (src.length() != svidx && pat.length() == pvidx) {
			return false;
		}
		if (src.length() == svidx & pat.length() != pvidx) {
			// ' ' and '****'
			for (int i = pvidx; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}

		if (storage[svidx][pvidx] != 0) {
			return (storage[svidx][pvidx] == 2) ? true : false;
		}

		char chs = src.charAt(svidx);
		char chp = pat.charAt(pvidx);

		boolean ans;
		if (chp == chs || chp == '?') {
			ans = wildcardMatchingTopDownDP(src, pat, svidx + 1, pvidx + 1, storage);
		} else if (chp == '*') {
			// blank
			boolean blank = wildcardMatchingTopDownDP(src, pat, svidx, pvidx + 1, storage);
			// multiple
			boolean multiple = wildcardMatchingTopDownDP(src, pat, svidx + 1, pvidx, storage);

			ans = blank || multiple;
		} else {
			// first character notmatching
			ans = false;
		}
		// ternary operator
		storage[svidx][pvidx] = (ans == true ? 2 : 1);// if ans == true, store 2 otherwise store 1
		return ans;
	}

	public static boolean wildcardMatchingBottomUpDP(String src, String pat) {
		boolean[][] storage = new boolean[src.length() + 1][pat.length() + 1];
		storage[src.length()][pat.length()] = true;

		// for last col, the default value is true so we dont fill that
		// explicitly,instead we fill from the second last cols
		for (int row = src.length(); row >= 0; row--) {
			// we start filling from second last col
			for (int col = pat.length() - 1; col >= 0; col--) {
				if (row == src.length()) {
					if (pat.charAt(col) == '*') {
						storage[row][col] = storage[row][col + 1];
					} else {
						storage[row][col] = false;
					}
				} else {
					char chs = src.charAt(row);
					char chp = pat.charAt(col);

					boolean ans;
					if (chp == chs || chp == '?') {
						ans = storage[row + 1][col + 1];
					} else if (chp == '*') {
						// blank
						boolean blank = storage[row][col + 1];
						// multiple
						boolean multiple = storage[row + 1][col];

						ans = blank || multiple;
					} else {
						// first character notmatching
						ans = false;
					}
					// ternary operator
					storage[row][col] = ans;
				}
			}
		}
		return storage[0][0];
	}
}
