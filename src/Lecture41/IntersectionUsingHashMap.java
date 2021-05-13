package Lecture41;

import java.util.HashMap;

public class IntersectionUsingHashMap {

	public static void main(String[] args) {
		int[] one = { 30, 20, 40, 50, 70, 30, 20, 20, 50, 50 };
		int[] two = { 50, 80, 30, 20, 20, 20, 90, 50, 20 };
		intersection(one, two);

	}

	//O(m+n)
	//S(m)
	public static void intersection(int[] one, int[] two) {
		HashMap<Integer, Integer> map = new HashMap<>();

		// traversal on the first array
		for (int key : one) {//O(m)
//			if (map.containsKey(key)) {
//				int oldfreq = map.get(key);
//				int newfreq = oldfreq + 1;
//				map.put(key, newfreq);// updated freq
//			} else {
//				map.put(key, 1);
//			}
//		}
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		for (int key : two) {//O(n)
			if (map.containsKey(key) && map.get(key) > 0) {
				System.out.println(key);
				map.put(key, map.get(key) - 1);
			}
		}
		
		System.out.print(map+" ");
	}

}
