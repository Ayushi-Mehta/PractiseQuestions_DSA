package Lecture13;

import java.util.ArrayList;
import java.util.Scanner;

public class coinToss {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		ArrayList<String> k = Toss(n);
		System.out.println(k);
	}
	public static ArrayList<String> Toss(int n){
		if(n==0) {
			ArrayList<String> br= new ArrayList<>();
			br.add("");
			return br;
		}
		char ch1='H';
		char ch2='T';
		ArrayList<String> rr= Toss(n-1);
		ArrayList<String> mr= new ArrayList<String>();
		for(String val: rr) {
			mr.add(ch1 + val);// bc -> ch NO
			mr.add(ch2 + val);
			}
		return mr;
	}
}
