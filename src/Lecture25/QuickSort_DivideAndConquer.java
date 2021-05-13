package Lecture25;

public class QuickSort_DivideAndConquer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 80, 10, 50, 30, 60, 20, 70, 25 };
		quickSort(arr, 0, arr.length-1);
		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	//O(nlogn)
	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		// partitioning
		int left = lo;
		int right = hi; 

		while (left <= right) {

			// left stop problem
			while (arr[left] < pivot) {
				left++;
			}

			// right stop problem
			while (arr[right] > pivot) {
				right--;
			}

			// swap
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}
		}
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);
	}
}
