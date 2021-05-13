package Lecture6;

import java.util.Scanner;

public class searchIndexOfValue {
	static Scanner scn=new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter size of array");
		int n=scn.nextInt();
		int ar[]=TakeInput(n);
		System.out.println("enter value to be searched");
		int a=scn.nextInt();
		IndexOfValue(ar,a);

	}
	public static int[] TakeInput(int n) {
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("enter value at index"+" "+i);
			arr[i]=scn.nextInt();
		}
		return arr;
	}
	public static void IndexOfValue(int[] arr, int a) {
		int x=-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==a) {
				x=i;
			}
		}
		if(x==-1) {
			System.out.println("-1");
		}
		else {
			System.out.println("index is "+ x);
		}
	}

}
