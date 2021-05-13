package doubt_session_2;

import java.util.Arrays;
import java.util.Scanner;

public class aggressiveCows {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int c = scn.nextInt();
		int[] stalls = new int[n];
		for (int i = 0; i < n; i++) {
			stalls[i] = scn.nextInt();
		}
		// array should be sorted
		Arrays.sort(stalls);
		// logic
		// applying binary search to minimum distance
		int lo = 0;
		int hi = stalls[stalls.length - 1] - stalls[0];
		int finalAns = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (isItPossible(stalls, c, mid)) {
				// YES->POSSIBLE VALUE OF DISTANCE
				finalAns = mid;// value not lost if the function still keeps on calculating
				lo = mid + 1;
			} else {
				// NO->NOT POSSIBLE VALUE OF DISTANCE
				hi = mid - 1;
			}
		}
		System.out.print(finalAns);
	}

	public static boolean isItPossible(int[] stalls, int c, int mid) {
		int cowsPlaced = 1;
		int pos = stalls[0];// first cow in first stall
		for (int i = 1; i < stalls.length; i++) {
			if (stalls[i] - pos >= mid) {
				cowsPlaced++;
				pos = stalls[i];
				if (cowsPlaced == c) {
					return true;
				}
			}
		}
		return false;
	}

}
