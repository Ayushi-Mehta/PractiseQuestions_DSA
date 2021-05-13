package Lecture16;

import java.util.Scanner;


public class staircase_recursionPrint {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int k=staircase(0,n,"");
		System.out.println();
		System.out.println(count1);
		System.out.println(k);
	}
	
	static int count1=0;//GLOBAL VARIABLE CREATED IN HEAP
	//CAN BE CHANGED FROM ANY FUNCTION
	
	public static int staircase(int curr,int n,String ans) {
		if(curr==n) {//+ve base case
			System.out.print(ans+" ");
			count1++;
			return 1;
		}
		if(curr>n) {//-ve base case
			return 0;
		}
		int x=0;
		for(int i=1;i<=n;i++) {
			x=x+staircase(curr+i,n,ans+i);
		}
		//staircase(curr+1,n,ans+1);
		//staircase(curr+2,n,ans+2);
		//staircase(curr+3,n,ans+3);
		return x; 
	}
}
