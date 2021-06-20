package DynamicProgramming;

public class WineProblem_IMPORTANT {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 1, 4 };
//		System.out.println(WineProblemRecursion(arr, 0, arr.length - 1, 1));
//		System.out.println(WineProblemTopDownDP(arr, 0, 0, new int[arr.length][arr.length]));
		System.out.println(WineProblemBottomUpDP(arr));
	}

	// O(2^n)
	public static int WineProblemRecursion(int[] arr, int si, int ei, int yr) {
		if (si == ei) {
			return arr[si] * yr;
		}
		int start = WineProblemRecursion(arr, si + 1, ei, yr + 1) + arr[si] * yr;
		int end = WineProblemRecursion(arr, si, ei - 1, yr + 1) + arr[ei] * yr;

		int ans = Math.max(start, end);
		return ans;
	}

	// removing yr variable from arguments
	public static int WineProblemRecursion2(int[] arr, int si, int ei) {
		int yr = arr.length - (ei - si + 1) + 1;
		if (si == ei) {
			return arr[si] * yr;
		}
		int start = WineProblemRecursion2(arr, si + 1, ei) + arr[si] * yr;
		int end = WineProblemRecursion2(arr, si, ei - 1) + arr[ei] * yr;

		int ans = Math.max(start, end);
		return ans;
	}

	public static int WineProblemTopDownDP(int[] arr, int si, int ei, int[][] storage) {
		int yr = arr.length - (ei - si + 1) + 1;
		if (si == ei) {
			return arr[si] * yr;
		}
		if (storage[si][ei] != 0) {
			return storage[si][ei];
		}
		int start = WineProblemTopDownDP(arr, si + 1, ei, storage) + arr[si] * yr;
		int end = WineProblemTopDownDP(arr, si, ei - 1, storage) + arr[ei] * yr;

		int ans = Math.max(start, end);
		storage[si][ei] = ans;
		return storage[0][0];
	}

	// O(n^2),S(O(n^2))
	public static int WineProblemBottomUpDP(int[] arr) {
		int n = arr.length;
		int[][] storage = new int[n][n];
		// diagonally filled the array
		for (int slide = 0; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;
				// logic same as top down
				int yr = arr.length - (ei - si + 1) + 1;
				if (si == ei) {
					storage[si][ei] = arr[si] * yr;
				} else {
					int start = storage[si + 1][ei] + arr[si] * yr;
					int end = storage[si][ei - 1] + arr[ei] * yr;

					int ans = Math.max(start, end);
					storage[si][ei] = ans;
				}
			}
		}
		return storage[0][n - 1];
	}

}
