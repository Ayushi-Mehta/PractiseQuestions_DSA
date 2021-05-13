package doubt_session_2;

import java.util.Scanner;

public class maxCircularSum {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int k = maxCircularSum(arr);
			System.out.println(k);
			t--;
		}
	}

	public static int maxCircularSum(int[] arr) {
		// case1:contributing elements are not wrapping:KADANE
		int sumNotWrapping = kadane(arr);

		// case2:contrinbuting elements are wrapping:NCE are not wrapping
		int totalSum = 0;
		for (int i = 0; i < arr.length; i++) {
			totalSum = totalSum + arr[i];
			arr[i] = -arr[i];// inverting all signs
		}
		int sumNCE = kadane(arr);// sum of non contributing elements including '-' sign
		int sumWrapping = totalSum + sumNCE;
		return Math.max(sumNotWrapping, sumWrapping);
	}

	public static int kadane(int[] arr) {
		int sum = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum = Math.max(sum + arr[i], arr[i]);
			if (sum > max) {
				max = sum;
			}
		}

		return max;
	}

}
