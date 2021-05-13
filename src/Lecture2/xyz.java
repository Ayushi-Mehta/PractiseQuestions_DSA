package Lecture2;

import java.util.Scanner;

public class xyz {

	public static void main(String[] args) {
		 Scanner scn=new Scanner(System.in);
	        int n=scn.nextInt();
	        for(int i=1;i<=n;i++){
	            for(int j=n-i-1;j>=0;j--){
	                System.out.print(" ");
	            }
	            for(int k=1;k<=n;k++){
	                if(i==1||i==n||k==1||k==n){
	                    System.out.print("*");
	                }
	                else{
	                    System.out.print(" ");
	                }
	            }
	            System.out.println();
	        }

	}

}
