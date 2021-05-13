package Lecture3;

import java.util.Scanner;

public class decimalToBinary {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int a,b=1,ans=0;
		while(n>0) {
			a=n%2;
			ans=a*b+ans;
			b=b*10;
			n=n/2;
		}
		System.out.println(ans);
	}

}
