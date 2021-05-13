package DynamicProgramming;

public class BoardPath {

	public static void main(String[] args) {

		int n = 40;
		// System.out.println(boardPathRecursionDP(0, n));
		// System.out.println(boardPathTopDownDP(0, n, new int[n]));
		//System.out.println(boardPathBottomUpDP(n));
		System.out.println(boardPathBottomUpDP_SpaceEff(n));
	}

	public static int boardPathRecursionDP(int curr, int end) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += boardPathRecursionDP(curr + dice, end);
		}

		return count;
	}

	public static int boardPathTopDownDP(int curr, int end, int[] storage) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}

		if (storage[curr] != 0) {// reuse
			return storage[curr];
		}
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += boardPathTopDownDP(curr + dice, end, storage);
		}

		storage[curr] = count;
		// value stored into the changing variable index of the recursive call
		return count;
	}

	/*
	 * BOTTOM UP- 1->cell meaning 2->size of array 3->direction of filling the
	 * values 4->base case of top down to be filled into array from before
	 */

	// O(n),S(O(n))
	public static int boardPathBottomUpDP(int end) {
		int[] storage = new int[end + 6];

		storage[end] = 1;

		for (int i = end - 1; i >= 0; i--) {
			storage[i] = storage[i + 1] + storage[i + 2] + storage[i + 3] + storage[i + 4] + storage[i + 5]
					+ storage[i + 6];
		}

		return storage[0];
	}

	// O(n),S(O(1))
	public static int boardPathBottomUpDP_SpaceEff(int end) {
		int[] storage = new int[6];

		storage[0] = 1;

		for (int slide = 1; slide <= end; slide++) {
			int sum = storage[0] + storage[1] + storage[2] + storage[3] + storage[4] + storage[5];

			//a loop can also be used here
			storage[5] = storage[4];
			storage[4] = storage[3];
			storage[3] = storage[2];
			storage[2] = storage[1];
			storage[1] = storage[0];
			storage[0]=sum;

			// TAKE SPECIAL CARE OF THE ORDER OF SWAPS MADE
			// AS OTHERWISE storage[0] WOULD BE STORED IN THE ENTIRE ARRAY
		}
		
		return storage[0];
	}
}
