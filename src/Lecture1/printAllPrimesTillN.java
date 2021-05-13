package Lecture1;

import java.util.Scanner;

public class printAllPrimesTillN {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int n=scn.nextInt();
        int count=0;
        if(n<=1||n>=1000){
                count=1;
            }
		for(int i=2;i<=n;i++){
            count=0;
            for(int j=2;j<=i/2;j++){
                if(i%j==0){
                    count=1;
                    break;
                }
            }
             if(count==0){
                 System.out.println(i);
             }
		
        }

	
    }

}
