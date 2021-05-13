package Lecture12;

import java.util.ArrayList;

public class subsequencesWithASCII {

	public static void main(String[] args) {
		ArrayList<String> list = subsequenceASCII("abc");
		System.out.println(list);
	}
	public static ArrayList<String> subsequenceASCII(String str){
		if(str.equals("")) {
			ArrayList<String> br= new ArrayList<>();
			br.add("");
			return br;//size = 1 
		}
		char ch = str.charAt(0);// a
		String ros = str.substring(1);// bc
		int as=(int)str.charAt(0);

		ArrayList<String> rr = subsequenceASCII(ros);// [_,b,c,bc]

		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {//for br=rr(size=1) it runs once and adds 2 elements per run
			mr.add(val);// bc -> ch NO
			mr.add(ch + val);
			mr.add(val+ as);// abc -> ch YES
		}
		return mr;//size=4 for rr=br(size=1)
	}
}