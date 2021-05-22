package DynamicProgramming;

import java.util.Arrays;

public class KOrderedLCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "afbjrzgbwiolk";
		String s2 = "assfouhbn";

		int k = 2;
		// System.out.println(kOrderedLCSRecursive(s1, s2, k, 0, 0));
		int[][][] storage = new int[k + 1][s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage[0].length; j++) {
				Arrays.fill(storage[i][j], -1);
			}
		}
		System.out.println(kOrderedLCSTopDownDP(s1, s2, k, 0, 0, storage));
	}

	public static int kOrderedLCSRecursive(String s1, String s2, int k, int vidx1, int vidx2) {

		if (s1.length() == vidx1 || s2.length() == vidx2) {
			return 0;
		}

		int ans = 0;
		if (s1.charAt(vidx1) == s2.charAt(vidx2)) {
			ans = kOrderedLCSRecursive(s1, s2, k, vidx1 + 1, vidx2 + 1) + 1;
		} else {
			int o1 = kOrderedLCSRecursive(s1, s2, k, vidx1, vidx2 + 1);
			int o2 = kOrderedLCSRecursive(s1, s2, k, vidx1 + 1, vidx2);
			int o3 = 0;
			if (k >= 1) {
				o3 = kOrderedLCSRecursive(s1, s2, k - 1, vidx1 + 1, vidx2 + 1) + 1;
			}

			ans = Math.max(o1, Math.max(o2, o3));
		}
		return ans;
	}

	public static int kOrderedLCSTopDownDP(String s1, String s2, int k, int vidx1, int vidx2, int[][][] storage) {

		if (s1.length() == vidx1 || s2.length() == vidx2) {
			return 0;
		}
		if (storage[k][vidx1][vidx2] != -1) {
			return storage[k][vidx1][vidx2];
		}
		int ans = 0;
		if (s1.charAt(vidx1) == s2.charAt(vidx2)) {
			ans = kOrderedLCSTopDownDP(s1, s2, k, vidx1 + 1, vidx2 + 1, storage) + 1;
		} else {
			int o1 = kOrderedLCSTopDownDP(s1, s2, k, vidx1, vidx2 + 1, storage);
			int o2 = kOrderedLCSTopDownDP(s1, s2, k, vidx1 + 1, vidx2, storage);
			int o3 = 0;
			if (k >= 1) {
				o3 = kOrderedLCSTopDownDP(s1, s2, k - 1, vidx1 + 1, vidx2 + 1, storage) + 1;
			}

			ans = Math.max(o1, Math.max(o2, o3));
		}

		storage[k][vidx1][vidx2] = ans;
		return ans;
	}

	public static int kOrderedLCSBottomUpDP(String s1, String s2, int tk) {

		int[][][] storage = new int[tk + 1][s1.length() + 1][s2.length() + 1];

		for (int k = 0; k <= tk; k++) {
			for (int row = s1.length() - 1; row >= 0; row--) {
				for (int col = s2.length() - 1; col >= 0; col--) {
					int ans = 0;
					if (s1.charAt(row) == s2.charAt(col)) {
						ans = storage[k][row + 1][col + 1] + 1;
					} else {
						int o1 = storage[k][row][col + 1];
						int o2 = storage[k][row + 1][col];
						int o3 = 0;
						if (k >= 1) {
							o3 = storage[k - 1][row + 1][col + 1] + 1;
						}

						ans = Math.max(o1, Math.max(o2, o3));
					}

					storage[k][row][col] = ans;
				}
			}
		}

		return storage[tk][0][0];
	}

}
