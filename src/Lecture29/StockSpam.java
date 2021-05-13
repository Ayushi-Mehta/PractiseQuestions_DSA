package Lecture29;

import java.util.Stack;

public class StockSpam {

	public static void main(String[] args) {
		int[] arr = { 80, 50, 70, 30, 20, 40, 90, 10, 5, 35 };
		stockSpan(arr);
	}

	public static void stockSpan(int[] arr) {
		Stack<Integer> s = new Stack<Integer>();
		// indexes pushed into the stack so that we can calculate the difference and
		// know the value of the no of days
		int[] ans = new int[arr.length];
		s.push(0);
		ans[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				s.pop();
			}
			if (s.isEmpty()) {
				ans[i] = i + 1;
			} else {
				ans[i] = i - s.peek();
			}
			s.push(i);// higher valued indexes pushed into the stack
		}
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

}
