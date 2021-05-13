package Lecture2;

import java.util.Scanner;

public class pattern9 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=n+i-2;j>=2*i-1;j--) {
				System.out.print("  ");
			}
			for(int k=1;k<=2*i-1;k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		

	}

	}


