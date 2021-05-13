package Lecture12;

import java.util.ArrayList;

public class subsequences {

	public static void main(String[] args) {
		ArrayList<String> list = subsequence("abc");
		System.out.println(list);
	}

	public static ArrayList<String> subsequence(String str) {
		if(str.equals("")) {
			//or str.length() ==0		
			/*
			 * dont use str == " "
			 * as it compares addresses rather than values
			 */
			ArrayList<String> br= new ArrayList<>();
			br.add("");
			return br;//size = 1 
		}
		char ch = str.charAt(0);// a
		String ros = str.substring(1);// bc

		ArrayList<String> rr = subsequence(ros);// [_,b,c,bc]

		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {//for br=rr(size=1) it runs once and adds 2 elements per run
			mr.add(val);// bc -> ch NO
			mr.add(ch + val);// abc -> ch YES
		}

		return mr;//size=4 for rr=br(size=1)
	}
}
