package Lecture14;

import java.util.ArrayList;
import java.util.Scanner;

public class climbingStairs {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(climb(0, n));

	}

	public static ArrayList<String> climb(int curr, int n) {
		if (curr == n) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");// MOST IMP LINE!!!
			return br;// blank arraylist

		}
		/*if (curr > n) {
			ArrayList<String> br = new ArrayList<String>();
			return br;
		}*/

		ArrayList<String> mr = new ArrayList<String>();

		for (int jump = 1; jump <= 3; jump++) {// && curr+jump <= n 
			if (curr + jump <= n) {
				ArrayList<String> rr = climb(curr + jump, n);// 1 jump
				for (String val : rr) {
					mr.add(jump + val);
				}
			}
		}

		return mr;
	}
}
