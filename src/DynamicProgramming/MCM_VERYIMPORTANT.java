package DynamicProgramming;

public class MCM_VERYIMPORTANT {
	// MATRIX CHAIN MULTIPLICATION
	public static void main(String[] args) {
		int[] arr = { 4, 2, 3, 5, 1 };
		// System.out.println(mcmRecursion(arr, 0, arr.length - 1));
		// System.out.println(mcmTopDownDP(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		System.out.println(mcmBottomUpDP(arr));
	}

	public static int mcmRecursion(int[] arr, int si, int ei) {
		// base case
		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {// k takes care of no of splits
			// k:splits

			// first problem
			int fp = mcmRecursion(arr, si, k);// arr[si]*arr[k]
			// second probbelm
			int sp = mcmRecursion(arr, k, ei);// arr[k]*arr[ei]

			// self work to multiply the resultant two matrices form the two recursive calls
			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}
		}
		return min;
	}

	public static int mcmTopDownDP(int[] arr, int si, int ei, int[][] storage) {
		// base case
		if (si + 1 == ei) {
			return 0;
		}

		// reuse
		if (storage[si][ei] != 0) {
			return storage[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {// k takes care of no of splits
			// k:splits

			// first problem
			int fp = mcmTopDownDP(arr, si, k, storage);// arr[si]*arr[k]
			// second probbelm
			int sp = mcmTopDownDP(arr, k, ei, storage);// arr[k]*arr[ei]

			// self work to multiply the resultant two matrices form the two recursive calls
			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}
		}
		// storage
		storage[si][ei] = min;
		return min;
	}

	// O(n^3),S(O(n^2))
	//filling done diagonally
	public static int mcmBottomUpDP(int[] arr) {
		int n = arr.length;
		int[][] storage = new int[n][n];

		// O(n^2)
		for (int slide = 1; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

				// logic used in top down
				if (si + 1 == ei) {
					storage[si][ei] = 0;
				} else {

					int min = Integer.MAX_VALUE;
					// O(n)
					for (int k = si + 1; k <= ei - 1; k++) {// k takes care of no of splits
						// k:splits

						// first problem
						int fp = storage[si][k];// arr[si]*arr[k]
						// second probbelm
						int sp = storage[k][ei];// arr[k]*arr[ei]

						// self work to multiply the resultant two matrices form the two recursive calls
						int sw = arr[si] * arr[k] * arr[ei];

						int total = fp + sp + sw;

						if (total < min) {
							min = total;
						}
					}
					// storage
					storage[si][ei] = min;
				}
			}
		}

		return storage[0][n - 1];
	}
}
