package Lecture7;

import java.util.Scanner;

public class barGraph {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("size?");
		int n=scn.nextInt();
		System.out.println("enter values");
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		barGraph(arr);
	}
	public static void barGraph(int[] arr) {
		int n=arr.length;
		int a=maxValue(arr);
		int max=a;
		for(int i=0;i<a;i++) {
			for(int j=0;j<n;j++) {
				if(arr[j]>=max) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}
			max--;
			System.out.println();
		}
	}
	public static int maxValue(int[] arr) {
		int n=arr.length;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		return max;
	}
}
