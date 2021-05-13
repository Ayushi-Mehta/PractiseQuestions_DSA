package Lecture7;

import java.util.Scanner;

public class subArrays_IMPORTANT {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter size");
		int n = scn.nextInt();
		int[] arr = new int[n];
		System.out.println("enter values");
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		subArrays(arr);
	}

	public static void subArrays(int[] arr) {
		int a = arr.length - 1;
		for (int i = 0; i <= a; i++) {
			int sum = 0;
			for (int j = 0; j <= a; j++) {
				for (int k = i; k <= j; k++) {
					sum = sum + arr[k];
					System.out.println(sum);
					// System.out.print(arr[k]+" ");
				}
				System.out.println();
			}
		}
	}

	public static void printSubarray(int[] arr) {
		for (int si = 0; si <= arr.length - 1; si++) {
			for (int ei = si; ei <= arr.length - 1; ei++) {
				for (int k = si; k <= ei; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
	}
	public static void sumOfSubarray(int[] arr) {
		for (int si = 0; si <= arr.length - 1; si++) {
			for (int ei = si; ei <= arr.length - 1; ei++) {
				int sum = 0;
				for (int k = si; k <= ei; k++) {
					sum = sum + arr[k];
				}
				System.out.println(sum);
			}
		}
	}
	public static void maxSumOfSubarray(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int si = 0; si <= arr.length - 1; si++) {
			for (int ei = si; ei <= arr.length - 1; ei++) {
				int sum = 0;
				for (int k = si; k <= ei; k++) {
					sum = sum + arr[k];
				}
				if (sum > max)
					max = sum;
			}
		}
		System.out.println(max);
	}
	public static void sumOfSubarray2lLoops(int[] arr) {
		for (int si = 0; si <= arr.length - 1; si++) {
			int sum = 0;
			for (int ei = si; ei <= arr.length - 1; ei++) {
				sum = sum + arr[ei];
				System.out.println(sum);
			}
		}
	}
	public static void maxSumOfSubarray2lLoops(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int si = 0; si <= arr.length - 1; si++) {
			int sum = 0;
			for (int ei = si; ei <= arr.length - 1; ei++) {
				sum = sum + arr[ei];
				if (sum > max)
					max = sum;
			}
		}
		System.out.println(max);
	}
}