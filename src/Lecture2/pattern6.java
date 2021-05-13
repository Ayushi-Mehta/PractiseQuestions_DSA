package Lecture2;

import java.util.Scanner;

public class pattern6 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int k=0;k<2*i;k++) {
				System.out.print(" ");
			}
			for(int j=n-i;j>0;j--) {
				System.out.print("*");
			}
			
			System.out.println();
		}

	}

}


