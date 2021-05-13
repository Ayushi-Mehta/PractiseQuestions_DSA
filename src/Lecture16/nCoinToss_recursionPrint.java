package Lecture16;

import java.util.Scanner;

public class nCoinToss_recursionPrint {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		CoinToss1(n, "");
		System.out.println();
		CoinToss2(n, "",false);
	}

	public static void CoinToss1(int n, String ans) {
		if (n == 0) {
			System.out.print(ans + " ");
			return;
		}
		if (ans.length() >= 1 && ans.charAt(ans.length() - 1) == 'H' ) {
			CoinToss1(n - 1, ans + "T");
		} 
		else {
			CoinToss1(n - 1, ans + "H");
			CoinToss1(n - 1, ans + "T");
		}
	}
	
	public static void CoinToss2(int n, String ans,boolean isLastHeadIncluded) {
		if (n == 0) {
			System.out.print(ans + " ");
			return;
		}
		if (isLastHeadIncluded ) {
			CoinToss2(n - 1, ans + "T",false);
		} 
		else {
			CoinToss2(n - 1, ans + "H",true);
			CoinToss2(n - 1, ans + "T",false);
		}
	}
}
