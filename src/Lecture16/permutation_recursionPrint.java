package Lecture16;

import java.util.Scanner;

public class permutation_recursionPrint {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();// abc
		Perm1(s, "");
		System.out.println();
		Perm2(s,"");

	}

	public static void Perm1(String ques, String ans) {// abc,""

		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		// char ch=ques.charAt(0);//a
		// String roq=ques.substring(1);//bc
		/*
		 * this is not done as these change with every call
		 */

		for (int i = 0; i < ques.length(); i++) {
			// Perm(roq,ch+ans); ->WRONG!
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			/*
			 * roq changes with call so written inside loop
			 */
			Perm1(roq, ans + ques.charAt(i));
		}

	}

	public static void Perm2(String ques, String ans) {
		if(ques.length()==0) {
			System.out.print(ans+" ");
			return;
		}
		char ch=ques.charAt(0);//a
		String roq=ques.substring(1);//bc
		
		for(int i=0;i<=ans.length();i++) {//"=" imp here
			Perm2(roq,ans.substring(0,i)+ch+ans.substring(i));//"i"th element has to be retained in ans
		}
	}
}
