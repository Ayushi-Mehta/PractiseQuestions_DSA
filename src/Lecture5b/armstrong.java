package Lecture5b;

import java.util.Scanner;

public class armstrong {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int lower=scn.nextInt();
		int upper=scn.nextInt();
		loop(lower,upper);
	}
	public static int digits(int a) {
		int count=0;
		while(a>0) {
			count++;
			a=a/10;
		}
		return count;
	}
	public static int pow(int a,int b) {
		int c=(int)Math.pow(a, b);
	return c;
	}
	public static void loop(int lower, int upper){
		for(int i=lower;i<=upper;i++) {
			boolean res=isArmstrong(i);
			if(res) {
				System.out.println(i);
			}
			}
		}
	public static boolean isArmstrong(int n) {
		int b=digits(n);
		int sum=0,a=0,d=n;
		for(int i=0;i<b;i++) {
			a=d%10;
			sum=sum+pow(a,b);
			d=d/10;
		}
		if(sum==n) {
			return true;
		}
		else {
			return false;
		}
	}
}
