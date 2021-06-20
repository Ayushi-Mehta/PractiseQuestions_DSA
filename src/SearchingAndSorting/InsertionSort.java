package SearchingAndSorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {9,8,7,6,5,4,3,2,1};
		insertionsort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void insertionsort(int[] arr) {
		for (int i = 1; i <= arr.length - 1; i++) {
			int val = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > val) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = val;
		}
	}
}
