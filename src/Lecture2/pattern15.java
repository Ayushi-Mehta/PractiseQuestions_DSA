package Lecture2;

import java.util.Scanner;

public class pattern15 {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int i=1;
		int a=0,b=n;
		while(i<=2*n-1) {
			int j=0;
			while(j<a) {
				System.out.print("  ");
				j++;
				}
			int k=1;
			while(k<=b) {
				System.out.print("* ");
				k++;
			}
			if(i<n) {
				a=a+2;
				b--;
			}
			else {
				a=a-2;
				b++;
			}
			System.out.println();
			i++;
			}
	}

}
