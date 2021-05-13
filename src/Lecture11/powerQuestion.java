package Lecture11;

import java.util.Scanner;

public class powerQuestion {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x=scn.nextInt();
		int n=scn.nextInt();
		int a=power(x,n);
		System.out.println(a);
	}
	public static int power(int x, int n) {
		if(n==0) {
			return 1;
		}
		int ans=0;
		ans = x*power(x,n-1);
		return ans;
	}
}
