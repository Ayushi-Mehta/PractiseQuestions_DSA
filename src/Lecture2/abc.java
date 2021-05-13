package Lecture2;

import java.util.Scanner;

public class abc {

	public static void main(String[] args) {
				Scanner scn=new Scanner(System.in);
		        int n=scn.nextInt();
		        while(n>0){
		            int a=scn.nextInt();
		            int h=scn.nextInt();
		            int i=1;
		            int ans1=1,ans2=0;
		            while(ans1<=a){
		                int b=2*i+1;
		                ans1=ans1+b;
		                i++;
		            }
		            int j=1;
		            while(ans2<h){
		                int k=2*j;
		                ans2=ans2+k;
		                j++;
		            }
		            if(ans1>ans2){
		                System.out.println("Aayush");
		            }
		            else{
		                System.out.println("Harshit");
		            }
		            n--;
		        }
		    
		

	}

}
