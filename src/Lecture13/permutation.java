package Lecture13;

import java.util.ArrayList;
import java.util.Scanner;

public class permutation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = "abc";
		ArrayList<String> k = Perm(s);
		System.out.println(k);
	}
	public static ArrayList<String> Perm(String s){
		if(s.length()==0) {
			ArrayList<String> br= new ArrayList<>();
			br.add("");
			return br;
		}
		char ch=s.charAt(0);
		String ros=s.substring(1);
		ArrayList<String> rr= Perm(ros);
		ArrayList<String> mr= new ArrayList<String>();
		for(String val: rr) {
			for(int i=0;i<=val.length();i++) {
				mr.add(val.substring(0,i)+ch+val.substring(i));
			}
		}
		return mr;
	}
}
