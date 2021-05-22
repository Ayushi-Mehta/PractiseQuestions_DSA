package DynamicProgramming;

import java.util.Arrays;

public class LCSwith3Strings {

	public static void main(String[] args) {

		String s1 = "abfa";
		String s2 = "aejghflkd";
		String s3 = "aeigfhl";

		System.out.println(LCS3StringsRecursion(s1, s2, s3, 0, 0, 0));
		int[][][] storage = new int[s1.length()][s2.length()][s3.length()];
		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage[0].length; j++) {
				Arrays.fill(storage[i][j], -1);
			}
		}
		System.out.println(LCS3StringsTopDownDP(s1, s2, s3, 0, 0, 0, storage));
	}

	public static int LCS3StringsRecursion(String s1, String s2, String s3, int vidx1, int vidx2, int vidx3) {

		if (s1.length() == vidx1 || s2.length() == vidx2 || s3.length() == vidx3) {
			return 0;
		}
		int ans = 0;
		if (s1.charAt(vidx1) == s2.charAt(vidx2) && s2.charAt(vidx2) == s3.charAt(vidx3)) {
			ans = LCS3StringsRecursion(s1, s2, s3, vidx1 + 1, vidx2 + 1, vidx3 + 1) + 1;
		} else {
			int o1 = LCS3StringsRecursion(s1, s2, s3, vidx1 + 1, vidx2, vidx3);
			int o2 = LCS3StringsRecursion(s1, s2, s3, vidx1, vidx2 + 1, vidx3);
			int o3 = LCS3StringsRecursion(s1, s2, s3, vidx1, vidx2, vidx3 + 1);

			ans = Math.max(o1, Math.max(o2, o3));
		}

		return ans;
	}

	public static int LCS3StringsTopDownDP(String s1, String s2, String s3, int vidx1, int vidx2, int vidx3,
			int[][][] storage) {

		if (s1.length() == vidx1 || s2.length() == vidx2 || s3.length() == vidx3) {
			return 0;
		}
		if (storage[vidx1][vidx2][vidx3] != -1) {
			return storage[vidx1][vidx2][vidx3];
		}
		int ans = 0;
		if (s1.charAt(vidx1) == s2.charAt(vidx2) && s2.charAt(vidx2) == s3.charAt(vidx3)) {
			ans = LCS3StringsTopDownDP(s1, s2, s3, vidx1 + 1, vidx2 + 1, vidx3 + 1, storage) + 1;
		} else {
			int o1 = LCS3StringsTopDownDP(s1, s2, s3, vidx1 + 1, vidx2, vidx3, storage);
			int o2 = LCS3StringsTopDownDP(s1, s2, s3, vidx1, vidx2 + 1, vidx3, storage);
			int o3 = LCS3StringsTopDownDP(s1, s2, s3, vidx1, vidx2, vidx3 + 1, storage);

			ans = Math.max(o1, Math.max(o2, o3));
		}

		storage[vidx1][vidx2][vidx3] = ans;
		return ans;
	}

	public static int LCS3StringsBottomUpDP(String s1, String s2, String s3) {

		int[][][] storage = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

		for (int s1l = s1.length() - 1; s1l >= 0; s1l--) {
			for (int s2l = s2.length() - 1; s2l >= 0; s2l--) {
				for (int s3l = s3.length() - 1; s3l >= 0; s3l--) {
					int ans = 0;
					if (s1.charAt(s1l) == s2.charAt(s2l) && s2.charAt(s2l) == s3.charAt(s3l)) {
						ans = storage[s1l + 1][s2l + 1][s3l + 1] + 1;
					} else {
						int o1 = storage[s1l + 1][s2l][s3l];
						int o2 = storage[s1l][s2l + 1][s3l];
						int o3 = storage[s1l][s2l][s3l + 1];

						ans = Math.max(o1, Math.max(o2, o3));
					}

					storage[s1l][s2l][s3l] = ans;
				}
			}
		}

		return storage[0][0][0];

	}
}
