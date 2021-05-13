package Lecture2;

import java.util.Scanner;

public class pattern5 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		for(int i=1;i<n;i++) {
			for(int j=n;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=i;k>0;k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}

}
