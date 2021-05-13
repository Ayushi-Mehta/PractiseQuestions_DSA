package Lecture6;

import java.util.Scanner;

public class functionArray {
	static Scanner scn = new Scanner(System.in);// GLOBAL SCANNER MADE SO THAT YOU CAN TAKE INPUT IN ANY FUNCTION

	public static void main(String[] args) {
		int[] ar = takeInput();
		display(ar);
	}

	public static int[] takeInput() {// int[] written as we are returning the address of an array which isnt an
										// integer
		System.out.println("enter size of array");
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("enter-index" + i);
			arr[i] = scn.nextInt();
		}
		return arr;

	}

	public static void display(int[] a) {
		for (int val : a) {// ":" is imp , its not"="
			System.out.print(val + " ");

		}
		System.out.println();
	}
}
