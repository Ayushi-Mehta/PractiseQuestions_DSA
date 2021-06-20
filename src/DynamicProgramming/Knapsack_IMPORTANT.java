package DynamicProgramming;

import java.util.Arrays;

public class Knapsack_IMPORTANT {

	public static void main(String[] args) {
		int[] wt = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };
		int cap = 7;
		int[][] storage = new int[wt.length][cap + 1];
		System.out.println(KnapsackRecursion(wt, price, 0, cap));
		System.out.println(KnapsackTopDownDP(wt, price, 0, cap, storage));
		System.out.println(KnapsackBottomUpDP(wt, price, cap));
	}

	// O(2^n)
	public static int KnapsackRecursion(int[] wt, int[] price, int vidx, int cap) {
		// base case
		if (vidx == wt.length || cap == 0) {
			return 0;
		}
		// exclude
		int e = KnapsackRecursion(wt, price, vidx + 1, cap);

		int i = 0;
		if (cap >= wt[vidx]) {
			// include
			i = KnapsackRecursion(wt, price, vidx + 1, cap - wt[vidx]) + price[vidx];
		}

		int ans = Math.max(e, i);
		return ans;
	}

	public static int KnapsackTopDownDP(int[] wt, int[] price, int vidx, int cap, int[][] storage) {
		// base case
		if (vidx == wt.length || cap == 0) {
			return 0;
		}
		// vidx and cap both are changing variables so it makes this a 2D array
		// --IMPORTANT
		if (storage[vidx][cap] != 0) {
			return storage[vidx][cap];
		}
		// exclude
		int e = KnapsackTopDownDP(wt, price, vidx + 1, cap, storage);

		int i = 0;
		if (cap >= wt[vidx]) {
			// include
			i = KnapsackTopDownDP(wt, price, vidx + 1, cap - wt[vidx], storage) + price[vidx];
		}

		int ans = Math.max(e, i);
		storage[vidx][cap] = ans;
		return ans;
	}

	// O(n*cap),S(O(n*cap))
	// filling not done orderly
	public static int KnapsackBottomUpDP(int[] wt, int[] price, int cap) {
		int n = wt.length;
		int[][] storage = new int[n + 1][cap + 1];

		for (int row = n - 1; row >= 0; row--) {
			for (int col = 1; col <= cap; col++) {
				int e = storage[row + 1][col];
				int i = 0;
				if (col >= wt[row]) {
					i = storage[row + 1][col - wt[row]] + price[row];
				}
				int ans = Math.max(e, i);
				storage[row][col] = ans;

			}
		}
		return storage[0][cap];
	}
}
