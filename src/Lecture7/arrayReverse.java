package Lecture7;

import java.util.Scanner;

public class arrayReverse {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter size of array");
		int n=scn.nextInt();
		int[] ar=new int[n];
		System.out.println("Enter array values");
		for(int i=0;i<n;i++) {
			ar[i]=scn.nextInt();
		}
		Reverse(ar);
	}
	public static void Reverse(int[] arr) {
		int temp=0;
		int a=arr.length-1;
		for(int i=0;i<=a/2;i++) {
			temp=arr[i];
			arr[i]=arr[a-i];
			arr[a-i]=temp;
		}
		for(int i=0;i<=a;i++) {
			System.out.println(arr[i]+" "+i);
		}
	}
}
