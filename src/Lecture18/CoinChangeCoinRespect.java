package Lecture18;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeCoinRespect {

	public static void main(String[] args) {
		List<List<Integer>> main = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		coinRespect(new int[] { 1, 2, 3 }, 0, 4, temp, main);
		System.out.println(main);
	}

	public static void CoinRespect(int[] denom, int vidx, int amount, String ans) {
		if (amount == 0) {// +ve base case
			System.out.println(ans);
			return;
		}
		if (amount < 0 || vidx == denom.length) {// -ve base case
			return;
		}
		// yes contribution
		CoinRespect(denom, vidx, amount - denom[vidx], ans + denom[vidx]);
		// no
		CoinRespect(denom, vidx + 1, amount, ans);
		// implicitly undo all hora hai
	}

	public static void coinRespect(int[] denom, int vidx, int amount, List<Integer> temp, List<List<Integer>> main) {
		if (amount == 0) {// +ve base case
			// System.out.println(ans);
			main.add(new ArrayList<Integer>(temp));
			return;
		}
		if (amount < 0 || vidx == denom.length) {// -ve base case
			return;
		}
		// yes contribution
		temp.add(denom[vidx]);
		coinRespect(denom, vidx, amount - denom[vidx], temp, main);
		temp.remove(temp.size()-1);
		// no
		coinRespect(denom, vidx + 1, amount, temp, main);
		// implicitly undo all hora hai
	}
}
