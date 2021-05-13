package Lecture17;

import java.util.Scanner;

public class lexicographicalCounting {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		lexicoCounting(0,n);

	}
	public static void lexicoCounting(int curr,int n) {
		
		if(curr>n) {//dont add curr==n here as it wont print n then
			return;
		}
		int i=0;
		System.out.print(curr +" ");
		if(curr==n) {
			return;
		}
		if(curr==0) {
			i=1;
		}
		while(i<=9) {
			lexicoCounting(curr*10+i,n);
			i++;
		}
	}
}