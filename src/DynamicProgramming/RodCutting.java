package DynamicProgramming;

public class RodCutting {

	public static void main(String[] args) {
		int[] price = { 0, 3, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(rodcuttingRecursion(price, price.length - 1));
		System.out.println(rodcuttingTopDownDP(price, price.length - 1, new int[price.length]));
		System.out.println(rodcuttingBottomUpDP(price));
	}

	// n=length of rod to be sold
	public static int rodcuttingRecursion(int[] price, int n) {
		int left = 1;
		int right = n - 1;
		int max = price[n];// profit made if you sell the rod as it is without cutting its
		while (left <= right) {
			int fp = rodcuttingRecursion(price, left);
			int sp = rodcuttingRecursion(price, right);

			int total = fp + sp;
			if (total > max) {
				max = total;
			}

			left++;
			right--;
		}
		return max;
	}

	public static int rodcuttingTopDownDP(int[] price, int n, int[] storage) {
		if (storage[n] != 0) {// reuse
			return storage[n];
		}

		int left = 1;
		int right = n - 1;
		int max = price[n];// profit made if you sell the rod as it is without cutting its

		while (left <= right) {
			int fp = rodcuttingTopDownDP(price, left, storage);
			int sp = rodcuttingTopDownDP(price, right, storage);

			int total = fp + sp;
			if (total > max) {
				max = total;
			}

			left++;
			right--;
		}
		storage[n] = max;
		return max;
	}

	public static int rodcuttingBottomUpDP(int[] price) {
		int[] storage = new int[price.length];

		storage[0] = price[0];
		storage[1] = price[1];

		for (int n = 2; n < storage.length; n++) {
			int left = 1;
			int right = n - 1;
			int max = price[n];// profit made if you sell the rod as it is without cutting its

			while (left <= right) {
				int fp = storage[left];
				int sp = storage[right];

				int total = fp + sp;
				if (total > max) {
					max = total;
				}

				left++;
				right--;
			}
			storage[n] = max;
		}
		return storage[storage.length - 1];
	}
}
