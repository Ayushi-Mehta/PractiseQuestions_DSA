package Lecture7;

import java.util.Scanner;

import sun.jvm.hotspot.tools.SysPropsDumper;

public class arrayRotate {

	static Scanner scn= new Scanner(System.in);
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
			Rotate(arr,rot);
	}
	public static void Rotate(int[]arr, int rot) {
		int temp=0;
		rot=rot%arr.length;
		/*
		TO DECREASE THE NO OF ROTATIONS WHEN ROT IS HIGH
		eg rot=14 for arr.length=6
		net result becomes two rotations
		which is 14%6
		*/
		if(rot<0) {
			rot=rot+arr.length;//NO NEED TO WRITE ANOTHER LOGIC FOR NEGATIVE PATH
		}
		/*
		 * circular track, total 6 steps
		 * -2 steps is same as +4 steps 
		 * SO NEW ROT = ROT(-2)+ARR.LENGTH(6)
		 */
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
