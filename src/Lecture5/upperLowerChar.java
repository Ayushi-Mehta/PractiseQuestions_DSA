package Lecture5;

import java.util.Scanner;

public class upperLowerChar {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		char ch=scn.next().charAt(0);
		if(ch<='z' && ch>='a') {
			System.out.println("Lower");
		}
		else if(ch>='A' && ch<='Z') {
			System.out.println("Upper");
		}
		else {
			System.out.println("Invalid");
		}
	}

}
