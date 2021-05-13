package Lecture7;

import java.util.Scanner;

public class inverseArray {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("enter size");
		int n=scn.nextInt();
		int[] arr=new int[n];
		System.out.println("enter values");
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		Inverse(arr);

	}
	public static void Inverse(int[] arr) {
		int n=arr.length;
		int[] arr2=new int[n];
		for(int i=0;i<n;i++) {
			arr2[arr[i]]=i;
		}
		for(int i=0;i<n;i++) {
			System.out.print(arr2[i]+" ");
		}
	}
}
