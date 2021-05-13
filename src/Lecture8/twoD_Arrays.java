package Lecture8;

public class twoD_Arrays {

	public static void main(String[] args) {
		int[][] arr = null;
		System.out.println(arr);
		arr = new int[3][5];
		System.out.println(arr);

		System.out.println("rows=" + arr.length);
		System.out.println("cols=" + arr[0].length);

		for (int i = 0; i < arr.length; i++) {
			// int[] a=arr[i]->stored 5k in another array
			System.out.println(arr[i]);
			for (int j = 0; j < arr[i].length; j++) {// "a.length" can be used here now
				/*
				 * "[i]" is imp here 0 can also be written since array was rectangular
				 */
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		// PRINTING A PARTICULAR ROW(no 1)
		for (int i = 0; i < arr[1].length; i++) {
			System.out.print(arr[1][i] + " ");
		}
		System.out.println();
		// updating a value
		arr[1][3] = 60;
		for (int i = 0; i < arr.length; i++) {
			int[] a = arr[i];
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
		// ENHANCED FOR LOOP
		for (int[] a : arr) {// ":" imp for enhanced loop
			/*
			 * int[] is the data type of a a stores address of the next array so you keep
			 * int[] arr=2k a traverses the array of arrays
			 */
			System.out.println(a);
			for (int val : a) {
				/*
				 * a=3k has 1D array at it youre traversing val for value of arr[1][0] val is an
				 * int value
				 */
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
}
