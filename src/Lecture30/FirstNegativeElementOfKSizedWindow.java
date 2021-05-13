package Lecture30;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeElementOfKSizedWindow {

	public static void main(String[] args) {

		int[] arr = { 10, -1, -8, 6, 30, 40, 50, 60 };
		firstNegativeWindow(arr, 3);
	}

	public static void firstNegativeWindow(int[] arr, int k) {// O(n)
		Queue<Integer> q = new LinkedList<Integer>();
		/*
		 * dont write new Queue here always use new LinkedList for inbuilt queue queue
		 * is an interface and not a class so its object cannot be made LL is child
		 * class of queue so the child class is used to make the object and that is how
		 * you use queue
		 */

		// initial window made
		for (int i = 0; i < k; i++) {// O(k)
			if (arr[i] < 0) {
				q.add(i);
			}
		}

		// ans for first window
		if (q.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(arr[q.peek()]);// arr[1]=-1
		}

		for (int i = k; i < arr.length; i++) {// O(n-k)
			// remove
			if (!q.isEmpty() && q.peek() == i - k) {
				q.remove();
			}

			// add
			if (arr[i] < 0) {
				q.add(i);
			}

			// ans for rest all windows
			if (q.isEmpty()) {
				System.out.println(0);
			} else {
				System.out.println(arr[q.peek()]);// arr[1]=-1
			}
		}
	}
}
