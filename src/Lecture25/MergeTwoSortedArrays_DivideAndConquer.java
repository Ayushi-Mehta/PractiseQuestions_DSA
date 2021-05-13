package Lecture25;

public class MergeTwoSortedArrays_DivideAndConquer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = { 10, 30, 50, 80, 100 };
		int[] two = { 15, 20, 25, 60, 70 };
		int[] ans = merge2SortedArrays(one, two);
		for (int val : ans) {
			System.out.print(val + " ");
		}
	}

	public static int[] merge2SortedArrays(int[] one, int[] two) {
		int[] ans = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				ans[k] = one[i];
				i++;
				k++;
			} else {
				ans[k] = two[j];
				j++;
				k++;

			}
		}
		if (j == two.length) {
			while (i < one.length) {
				ans[k] = one[i];
				i++;
				k++;
			}
		}
		if (i == one.length) {
			while (j < two.length) {
				ans[k] = two[j];
				j++;
				k++;
			}
		}
		return ans;
	}
}
