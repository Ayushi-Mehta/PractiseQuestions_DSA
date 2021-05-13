package Lecture3;

import java.util.Scanner;

public class rotateDigitsOfN {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int rot=scn.nextInt();
		int count=0,p=n;
		while(p!=0) {
			count++;
			p=p/10;
		}
		int ans=0,multi=0;
		if(n>0) {
			for(int i=0;i<n;i++) {
				
				int a=n%10;
				int b=n/10;
				multi=(int) Math.pow(10,count-1);
				ans=a*multi+b;
				count--;
				n=n/10;
			}-
		}
		System.out.println(ans);

	}

}
