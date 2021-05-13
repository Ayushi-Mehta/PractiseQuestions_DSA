package Lecture1;

import java.util.Scanner;

public class reverseDigitsOfNumber {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int a,b=0;
		while(n>0) {
			a=n%10;
			b=b*10+a;
			n=n/10;
		}
		System.out.println(b);
	}

}
