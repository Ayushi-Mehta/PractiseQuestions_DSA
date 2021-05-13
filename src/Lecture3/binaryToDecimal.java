package Lecture3;

import java.util.Scanner;

public class binaryToDecimal {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int rem=0,multi=1,ans=0;
		while(n>0) {
			rem=n%10;
			if(rem==1) {
			ans=rem*multi+ans;
			}
			multi=multi*2;
			n=n/10;
		}
		System.out.println(ans);

	}
}
