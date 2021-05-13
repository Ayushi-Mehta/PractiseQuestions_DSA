package Lecture1;

import java.util.Scanner;

public class ReportCard {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		if(n<60) {
			System.out.println("Grade D");
		}
		else if(n>=60&&n<70) {
			System.out.println("Grade C");
		}
		else if(n>=70&&n<80) {
			System.out.println("Grade B");
		}
		else if(n>=80&&n<90) {
			System.out.println("Grade A");
		}
		else {
			System.out.println("Grade A+");
		}

	}

}
