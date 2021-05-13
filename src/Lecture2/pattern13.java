package Lecture2;

import java.util.Scanner;

public class pattern13 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int i=1;
		int m=1;
		while(i<=2*n-1) {
			int j=1;
			while(j<=m) {
				System.out.print("*");
				j++;
			}
			if(i<n) {
				m++;
			}
			else {
				m--;
			}
			System.out.println();
			i++;
		}

	}

}
