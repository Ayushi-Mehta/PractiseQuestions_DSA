package doubt_session_2;

import java.util.ArrayList;
import java.util.Arrays;

public class jumpingNos {
	public static void main(String[] args) {
		System.out.println(jumpingNumbers(191));

	}

	public static int[] jumpingNumbers1(int x) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		for (int i = 0; i <= x; i++) {
			if (isJumping(i)) {
				list.add(i);
			}
		}
		list3 = order(list);
		int size = list.size();
		// String[] ans= new String[size];
		// for(int i=0;i<size;i++){
		// ans[i]=String.valueOf(list.get(i));
		// }
		// Arrays.sort(ans);
		int[] temp = new int[size];
		for (int i = 0; i < list.size(); i++) {
			temp[i] = list3.get(i);
		}
		return temp;
	}

	public static boolean isJumping1(int n) {
		int digits = 0, b = n, x = n;
		while (b > 0) {
			digits++;
			b = b / 10;
		}
		if (digits == 1) {
			return true;
		}
		for (int i = 0; i < digits - 1; i++) {
			int c = (int) Math.pow(10, digits - 1 - i);
			int d = x / c;
			int e = c / 10;
			x = x % c;
			int f = x / e;
			if (d - f == 1 || f - d == 1) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer> order(ArrayList<Integer> list) {
		int digits = 0, b = 0;
		int x = 0;
		int i = 0;
		int msd = 0;
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		while (list.size() != 0) {
			if (i == list.size()) {
				x++;
				i = 0;
			}
			int a = list.get(i);
			b = a;
			while (b > 0) {
				digits++;
				b = b / 10;
			}
			if (digits == 1) {
				msd = a;
			} else {
				int c = (int) Math.pow(10, digits - 1);
				msd = a / c;
			}
			if (msd == x) {
				int num = list.remove(i);
				list2.add(num);
			}
			i++;
		}
		return list2;
	}

	public static int[] jumpingNumbers(int x) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= x; i++) {
			if (isJumping(i)) {
				list.add(i);
			}
		}
	
		int size = list.size();
		 String[] ans= new String[size];
		 for(int i=0;i<size;i++){
		 ans[i]=String.valueOf(list.get(i));
		 }
		 Arrays.sort(ans);
		int[] temp = new int[size];
		for (int i = 0; i < list.size(); i++) {
			temp[i] =Integer.valueOf(ans[i]);
		}
		return temp;
	}

	public static boolean isJumping(int n) {
		int digits = 0, b = n, x = n;
		while (b > 0) {
			digits++;
			b = b / 10;
		}
		if (digits == 1) {
			return true;
		}
		for (int i = 0; i < digits - 1; i++) {
			int c = (int) Math.pow(10, digits - 1 - i);
			int d = x / c;
			int e = c / 10;
			x = x % c;
			int f = x / e;
			if (d - f == 1 || f - d == 1) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
