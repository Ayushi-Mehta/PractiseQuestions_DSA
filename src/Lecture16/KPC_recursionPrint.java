package Lecture16;

import java.util.Scanner;

public class KPC_recursionPrint {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s=scn.next();//145
		KPC(s,"");
	}
	public static void KPC(String ques, String ans) {
		if(ques.length()==0) {
			System.out.print(ans+" ");
			return;
		}
		
		char ch= ques.charAt(0);//1
		String roq= ques.substring(1);//45
		
		String code= getCode(ch);//abc
		
		for(int i=0;i<code.length();i++) {
			KPC(roq,ans+code.charAt(i));
		}
		
		
	}
	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}
}
