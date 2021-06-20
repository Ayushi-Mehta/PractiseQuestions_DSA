package DynamicProgramming;

public class LCS {
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "agcfd";
		// System.out.println(LCSRecursion(s1, s2));
		// System.out.println(LCSRecursionVirtualIndex(s1, s2, 0, 0));
//		int[][] storage = new int[s1.length()][s2.length()];
//		for (int i = 0; i < storage.length; i++) {
//			Arrays.fill(storage[i], -1);
//		}
		// System.out.println(LCSTopDownDP(s1, s2, 0, 0, storage));
		System.out.println(LCSBottomUpDP(s1, s2));
	}

	public static int LCSRecursion(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);// O(n) ->increases time complexity
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = LCSRecursion(ros1, ros2) + 1;
		} else {
			int o1 = LCSRecursion(s1, ros2);
			int o2 = LCSRecursion(ros1, s2);

			ans = Math.max(o1, o2);
		}
		return ans;
	}

	public static int LCSRecursionVirtualIndex(String s1, String s2, int vidx1, int vidx2) {
		if (s1.length() == vidx1 || s2.length() == vidx2) {
			return 0;
		}
		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;
		if (ch1 == ch2) {
			ans = LCSRecursionVirtualIndex(s1, s2, vidx1 + 1, vidx2 + 1) + 1;
		} else {
			int o1 = LCSRecursionVirtualIndex(s1, s2, vidx1 + 1, vidx2);
			int o2 = LCSRecursionVirtualIndex(s1, s2, vidx1, vidx2 + 1);

			ans = Math.max(o1, o2);
		}
		return ans;
	}

	// O(m*n),S(O(m*n + recursion extra space))
	public static int LCSTopDownDP(String s1, String s2, int vidx1, int vidx2, int[][] storage) {
		if (s1.length() == vidx1 || s2.length() == vidx2) {
			return 0;
		}

		if (storage[vidx1][vidx2] != -1) {// reuse
			return storage[vidx1][vidx2];
		}
		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;
		if (ch1 == ch2) {
			ans = LCSTopDownDP(s1, s2, vidx1 + 1, vidx2 + 1, storage) + 1;
		} else {
			int o1 = LCSTopDownDP(s1, s2, vidx1 + 1, vidx2, storage);
			int o2 = LCSTopDownDP(s1, s2, vidx1, vidx2 + 1, storage);

			ans = Math.max(o1, o2);
		}

		storage[vidx1][vidx2] = ans;// store values
		return ans;
	}

	//O(m*n),S(O(n*m))
	public static int LCSBottomUpDP(String s1, String s2) {
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {
				if(s1.charAt(row)==s2.charAt(col)) {
					storage[row][col]=storage[row+1][col+1]+1;
				}else {
					int o1=storage[row][col+1];
					int o2=storage[row+1][col];
					
					storage[row][col]=Math.max(o1, o2);
				}
			}
		}
		return storage[0][0];
	}

}
