package Lecture3;

import java.util.Scanner;

public class decimalToOctal {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int a,b=1,ans=0;
		while(n>0) {
			a=n%10;
			ans=a*b+ans;
			b=b*8;
			n=n/10;
		}
		System.out.println(ans);
	}

}
