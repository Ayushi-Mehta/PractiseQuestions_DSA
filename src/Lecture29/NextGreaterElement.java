package Lecture29;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = { 50, 30, 20, 40, 10, 45, 5, 60, 15, 8 };
		nextGreater(arr);
		System.out.println("--------------------------------");
	}

	public static void nextGreater(int[] arr) {// O(n)
		
		Stack<Integer> s = new Stack<Integer>();
		// s.push(arr[0]);
		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() && arr[i] > s.peek()) {
				System.out.println(s.pop() + " -> " + arr[i]);
			}
			s.push(arr[i]);
		}
		while (!s.isEmpty()) {
			System.out.println(s.pop() + " -> -1");
		}
	}

	public static void nextGreaterReverse(int[] arr) {
		int ng = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			while (ng > arr[i]) {
				// WOULD NOT WORK!!!
			}
		}
	}
}
