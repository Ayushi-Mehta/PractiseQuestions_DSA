package Lecture2;

import java.util.Scanner;

public class pattern14 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int i=1;
		int m=n-1;
		int p=1;
		while(i<=2*n-1) {
			int j=1;
			
			while(j<=m) {
				System.out.print(" ");
				j++;
			}
			int k=1;
			while(k<=p) {
			System.out.print("*");
			k++;
			}

			if(i<n) {
				m--;
				p++;
			}
			else {
				m++;
				p--;
			}
			System.out.println();
			i++;
		}

	}

}
