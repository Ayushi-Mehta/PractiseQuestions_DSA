package Lecture15;

public class printRecursion {

	public static void main(String[] args) {
		subsequences("abc", " ");
	}

	public static void subsequences(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		char ch = ques.charAt(0);// a
		String roq = ques.substring(1);// bc

		subsequences(roq, ans);// a->NO//bc,""
		subsequences(roq, ans + ch);// a->YES//bc,a

	}
}
