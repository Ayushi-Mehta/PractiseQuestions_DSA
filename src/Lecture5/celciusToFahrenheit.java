package Lecture5;

import java.util.Scanner;

public class celciusToFahrenheit {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int minF=scn.nextInt();
		int maxF=scn.nextInt();
		int step=scn.nextInt();
		for(int i=minF;i<=maxF;i=i+step) {
			int c=0;
			c=5*(i-32)/9;
			System.out.println(i+" "+c);
		}
	}

}
