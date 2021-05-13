package Lecture41;

import java.util.HashMap;

public class longestPossibleConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr= {13,25,2,18,16,12,5,3,6,8,10,1,11,9};
		longestConsecutiveSequence(arr);
	}

	public static void longestConsecutiveSequence(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int key : arr) {
			if (map.containsKey(key - 1)) {
				map.put(key, false);
			} else {
				map.put(key, true);
			}

			if (map.containsKey(key + 1)) {
				map.put(key + 1, false);
			}
		}

		int max = Integer.MIN_VALUE;
		int sp = 0;// starting point
		for (int key : map.keySet()) {
			if (map.get(key)) {// map.get(key) gives value
				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
					if (count > max) {
						max = count;
						sp = key;
					}
				}

			}

		}

		for (int i = sp; i < sp + max; i++) {
			System.out.print(i+" ");
		}

	}

}
