package Lecture3;

import java.util.Scanner;

public class octalToDecimal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int rem = 0, multi = 1, ans = 0;
		while (n > 0) {
			rem = n % 8;
			ans = rem * multi + ans;
			multi = multi * 10;
			n = n / 8;
		}
		System.out.println(ans);

	}

}
