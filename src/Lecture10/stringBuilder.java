package Lecture10;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class stringBuilder {

	public static void main(String[] args) {

		// string to stringbuilder
		String str = "hello";
		StringBuilder sb = new StringBuilder(str);

		// or SB can also be created like this
		// StringBuilder sb= new StringBuilder("hello");

		// print
		System.out.println(sb);

		// length
		System.out.println(sb.length());

		// charAt
		System.out.println(sb.charAt(3));// range 0 to length-1

		// substring
		System.out.println(sb.substring(2));// RETURNS STRING NOT STRINGBUILDER
		System.out.println(sb.substring(1, 4));

		// append
		sb.append("bye");// MAKES CHANGES IN ORIGINAL SB SO NOT STORED IN ANOTHER VARIALBLE
		System.out.println(sb);// you may store it in a variable as it returns too

		// insert-> range 0 to length
		sb.insert(2, "hi");// MAKES CHANGES IN ORIGINAL SB
		/*
		 * makes changes to original sb the next char after inserted char are shifted by
		 * n places to right ie shifted by n(=hi.length) index
		 */
		System.out.println(sb);

		// update/setCharAt->O(n)
		sb.setCharAt(1, 'y');// MAKES CHANGES IN ORIGINAL SB
		System.out.println(sb);

		// delete/remove
		sb.deleteCharAt(3);
		/*
		 * makes changes to original sb the next char after deleted char are shifted by
		 * one place to left ie shifted by 1 index
		 */
		System.out.println(sb);

		sb.delete(2, 5);
		System.out.println(sb);

		// Stringbuilder to String
		String s = sb.toString();

	}
	/*
	 * multiple string concatenation take too much time complwex instead make it a
	 * sb and append the sb time complexity becomes constant return using tostring
	 * ie sb to string
	 */

	/*
	 * there is no way to directly take input to a stringbuildrt so take a string
	 * input and convert to sb
	 */

	public static void appendString() {
		int n = 100000;

		// String str="";
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <= n; i++) {
			// str+=i;
			sb.append(i);// ->works in constant time!! as It only adds to the string rather than creating
						// a new one at new address
		}
	}
}
