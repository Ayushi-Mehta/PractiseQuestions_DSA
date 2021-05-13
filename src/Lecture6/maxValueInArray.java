package Lecture6;

import java.util.Scanner;

import sun.jvm.hotspot.tools.SysPropsDumper;

public class maxValueInArray {
	static Scanner scn= new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter size of array");
		int n=scn.nextInt();
		int[] ar=TakeInput(n);
		ReturnMax(ar);
	}
	public static int[] TakeInput(int n) {
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("enter value at index"+i);
			arr[i]=scn.nextInt();
		}
		return arr;
	}
	public static void ReturnMax(int[] a) {
		int x=Integer.MIN_VALUE;//VERY VERY IMPORTANT!!
		for(int i=0;i<a.length;i++) {
			if(a[i]>x) {	
				x=a[i];
			}
		}
		System.out.println("max value is"+" "+x);
	}
}
