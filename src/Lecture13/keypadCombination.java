package Lecture13;

import java.util.ArrayList;
import java.util.Scanner;

public class keypadCombination {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = (String) "145";// 145
		ArrayList<String> k = keyCode(s);
		System.out.println(k);
	}

	public static ArrayList<String> keyCode(String s) {
		//base case
		if(s.length()==0) {
			ArrayList<String> br= new ArrayList<>();
			br.add("");
			return br;//size = 1 
		}
		char ch = s.charAt(0);// 1
		String ros = s.substring(1);// 45
		// smaller problem
		ArrayList<String> rr = keyCode(ros);// [jl,jm,jn,jo,kl,km,kn,ko]
		// self work
		ArrayList<String> mr = new ArrayList<String>();
		String code = getCode(ch);// abc
		for (String val : rr) {
			for (int i = 0; i < code.length(); i++) {
				mr.add(code.charAt(i) + val);
			}
		}
		return mr;
	}

	public static String getCode(char ch) {
		if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "jk";
		} else if (ch == '5') {
			return "lmno";
		} else if (ch == '6') {
			return "pqr";
		} else if (ch == '7') {
			return "stu";
		} else if (ch == '8') {
			return "vwx";
		} else if (ch == '9') {
			return "yz";
		} else if (ch == '0') {
			return "@#";
		} else {
			return "";
		}
	}
}
