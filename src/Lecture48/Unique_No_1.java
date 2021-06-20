package Lecture48;

public class Unique_No_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 3, 2, 5, 7, 5 };
		System.out.println(uniquenumber1(arr));
		System.out.println(18 >> 3);// right shift
		System.out.println(8 << 3);// left shift
		System.out.println(-9 >> 1);

	}

	public static int uniquenumber1(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans = ans ^ arr[i];
			/*
			 * every pair of numbers will xor and cancel out to zero and the only single
			 * number will be remaining
			 */
		}
		return ans;
	}
}
