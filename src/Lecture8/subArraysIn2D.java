package Lecture8;

import java.util.Scanner;

public class subArraysIn2D {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] a=takeInput();
		display(a);
		
		//HARDCODING THE ARRAY
		//int[][] b= {{10,20,30},{3,4,5,6},{1,2,3,4,5}};
	}

	public static int[][] takeInput() {
		System.out.println("ROWS?");
		int row = scn.nextInt();
		System.out.println("COLS?");
		int col = scn.nextInt();

		int[][] arr = new int[row][col];

		System.out.println("GIVE INPUT");

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("arr["+i+"]["+j+"]");
				arr[i][j] = scn.nextInt();
			}
		}
		return arr;
	}
	
	public static void display(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
