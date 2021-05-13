 package Lecture25;

public class MergeSort_DivideAndConquer {//VERY IMPORTANT ALGO

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 80, 10, 50, 30, 60, 20, 70, 25 };
		int[] merged = mergeSort(arr, 0, arr.length - 1);
		for (int val : merged) {
			System.out.print(val+" ");
		}
	}

	//DIVIDE AND CONQUER BASED ALGO
	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;
		// divide
		// SP1->(arr,lo,mid)
		// SP2->(arr,mid+1,hi)
		// conquer
		int[] fp = mergeSort(arr, lo, mid);
		int[] sp = mergeSort(arr, mid + 1, hi);
		// combine
		int[] merged = merge2SortedArrays(fp, sp);
		return merged;
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
