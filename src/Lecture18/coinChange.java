package Lecture18;

public class coinChange {

	public static void main(String[] args) {
		CoinChangeCombination(new int[] {2,3,5,6},10,"",0);
		System.out.println("-------------------");
		CoinChangePermutation(new int[] {2,3,5,6},10,"");
	}

	public static void CoinChangeCombination(int[] denom, int amount, String ans, int lastDenomIdx) {
		if(amount==0) {
			System.out.println(ans);
			return;
		}
		for (int i = lastDenomIdx; i < denom.length; i++) {
			if (amount >= denom[i]) {
				CoinChangeCombination(denom, amount - denom[i], ans + denom[i], i);
			}
		}
		 
	}
	public static void CoinChangePermutation(int[] denom, int amount, String ans) {
		if(amount==0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < denom.length; i++) {
			if (amount >= denom[i]) {
				CoinChangePermutation(denom, amount - denom[i], ans + denom[i]);
			}
		}
		 
	}
}
