package Lecture1;

import java.util.Scanner;

public class sumOfNaturalNumbers {

	public static void main(String[] args) {
		Scanner scn =new Scanner(System.in);
		int n=scn.nextInt();
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum=sum+i;
		}
		System.out.println("Sum is "+ sum);

	}

}
