package Lecture3;

import java.util.Scanner;

public class digitsToPlaces {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int p=n,count=0;
		while(p>0) {
			count++;
			p=p/10;
		}
		int a=0,b=1,ans=0;
		int multi;
		while(count>0) {
			a=n%10;
			multi=(int)Math.pow(10, a-1);
			ans=ans+b*multi;
			n=n/10;
			b++;
			count--;
		}
		System.out.println(ans);
	}

}
