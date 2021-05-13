package Lecture17;

import java.util.ArrayList;

public class addParenthesis_IMPORTANT {

	public static void main(String[] args) {
		//ArrayList<Integer> rr= ;
		//for(int i : rr) {
			System.out.print(diffWaysToAddParenthesis("2+6-5*8+9-5").size());
		//}
	}

	public static ArrayList<Integer> diffWaysToAddParenthesis(String str) {
		ArrayList<Integer> mr = new ArrayList<Integer>();

		//operator is not present int the case with 2 being the only thing in the string
		if (str.indexOf('+') == -1 && str.indexOf('-') == -1 && str.indexOf('*') == -1) {
			mr.add(Integer.parseInt(str));
			return mr;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				// ith char is an operator :+ * -
				ArrayList<Integer> rr1 = diffWaysToAddParenthesis(str.substring(0, i));
				ArrayList<Integer> rr2 = diffWaysToAddParenthesis(str.substring(i + 1));
				for (int val1 : rr1) {
					for (int val2 : rr2) {
						if (ch == '+') {
							mr.add(val1 + val2);
						} else if (ch == '-') {
							mr.add(val1 - val2);
						} else if (ch == '*') {
							mr.add(val1 * val2);
						}
					}
				}
			}
		}
		return mr;
	}
}
