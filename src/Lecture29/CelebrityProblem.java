package Lecture29;

import java.util.Stack;

public class CelebrityProblem {

	public static void main(String[] args) {
		int[][] ar = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };
		celebrityProblem(ar);
	}

	public static void celebrityProblem(int[][] arr) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			s.push(i);
		}
		while (s.size() != 1) {
			int a = s.pop();
			int b = s.pop();

			// a knows b :a cannot be celebrity
			if (arr[a][b] == 1) {
				s.push(b);
			}
			// a doesn't know b : b cant be celebrity
			else {
				s.push(a);
			}
		}
		int candidate = s.pop();
		for (int i = 0; i < arr.length; i++) {
			if (i != candidate) {
				if (arr[candidate][i] == 1 || arr[i][candidate] == 0) {
					System.out.println("No Celebrity");
					return;
				}
			}
		}
		System.out.println(" Celebrity is " + candidate);
	}
}
