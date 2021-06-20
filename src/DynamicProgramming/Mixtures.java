package DynamicProgramming;

import java.util.Arrays;

public class Mixtures {

	public static void main(String[] args) {
		int[] arr = { 40, 60, 20, 50 };
		System.out.println(mixturesRecursion(arr, 0, arr.length - 1));
		int[][] storage = new int[arr.length][arr.length];
		for (int i = 0; i < storage.length; i++) {
			Arrays.fill(storage[i], -1);
		}
		System.out.println(mixturesTopDownDP(arr, 0, arr.length - 1, storage));
		System.out.println(mixturesBottomUpDP(arr));
	}

	public static int mixturesRecursion(int[] arr, int si, int ei) {
		if (si == ei) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = si; k <= ei - 1; k++) {
			int fp = mixturesRecursion(arr, si, k);
			int sp = mixturesRecursion(arr, k + 1, ei);

			int sw = color(arr, si, k) * color(arr, k + 1, ei);
			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}
		}
		return min;
	}

	public static int color(int[] arr, int i, int j) {
		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum += arr[k];
		}
		return sum % 100;
	}

	public static int mixturesTopDownDP(int[] arr, int si, int ei, int[][] storage) {
		if (si == ei) {
			return 0;
		}
		if (storage[si][ei] != -1) {
			return storage[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si; k <= ei - 1; k++) {
			int fp = mixturesTopDownDP(arr, si, k, storage);
			int sp = mixturesTopDownDP(arr, k + 1, ei, storage);

			int sw = color(arr, si, k) * color(arr, k + 1, ei);
			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}
		}
		storage[si][ei] = min;
		return min;
	}

	public static int mixturesBottomUpDP(int[] arr) {
		int n = arr.length;
		int[][] storage = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				if (si == ei) {
					storage[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;

					for (int k = si; k <= ei - 1; k++) {
						int fp = storage[si][k];
						int sp = storage[k + 1][ei];

						int sw = color(arr, si, k) * color(arr, k + 1, ei);
						int total = fp + sp + sw;

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

}
