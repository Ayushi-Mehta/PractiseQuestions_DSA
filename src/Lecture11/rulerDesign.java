package Lecture11;

import java.util.Scanner;

public class rulerDesign {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("length?");
		int length=scn.nextInt();
		System.out.println("ticks?");
		int ticks=scn.nextInt();

		ruler(length,ticks);
	}
	public static void ruler(int length, int ticks) {
		int count =0;
		System.out.println("----"+count);
	
	}
}
