package Lecture9;

import java.util.ArrayList;

public class sumOfTwoArrays {

	public static void main(String[] args) {
		int[] one = { 9, 9, 8, 7 };
		int[] two = { 6, 5 };

		ArrayList<Integer> res = new ArrayList<>();

		int i = one.length-1;
		int j = two.length-1;

		int sum = 0;
		int carry = 0;
		while (i>=0 || j>=0) {
			if (i >= 0 && j >= 0) {
				sum = one[i] + two[j] + carry;
			}
			else if (i >= 0 && j <= 0) {
				sum = one[i] + carry;
			} 
			else if (i <= 0 && j >= 0) {
				sum = two[j] + carry;
			}
			res.add(0,sum % 10);
			carry = sum / 10;
			i--;
			j--;
		}
		res.add(0,carry);

		for (int k : res) {
			System.out.print(k+" ");
		}
	} 

}
