package Lecture7;

import java.util.Scanner;

public class arrayRotateWay2 {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("enter your array size");
		int n=scn.nextInt();
		System.out.println("Enter array values");
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		System.out.println("enter size of rotation");
		int rot=scn.nextInt();
			RotateWay2(arr,rot);
	}
	public static void RotateWay2(int[]arr,int rot) {
		int n=arr.length;
		Rotate(arr, rot, n-rot)
	}
	public static void Rotate(int[]arr, int rot) {
		int temp=0;
		rot=rot%arr.length;
		if(rot<0) {
			rot=rot+arr.length;
		}
		int a=arr.length-1;
		for(int i=0;i<rot;i++) {
			temp=arr[a];
			for(int j=a;j>0;j--) {
				arr[j]=arr[j-1];
			}
			arr[0]=temp;
		}
		for(int i=0;i<=a;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
