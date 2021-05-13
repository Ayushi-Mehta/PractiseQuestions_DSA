package Lecture11;

public class lastOccurence {

	public static void main(String[] args) {
		int[] arr = { 10, 2, 90, 80, 90 };
		int element = 90;
		System.out.println(lastTime(arr, 0, element));
	}

	public static int lastTime(int[] arr, int index, int element) {
		if (index == arr.length) {
			return -1;
		}
		int last = lastTime(arr, index + 1, element);
		if (arr[index] == element && last == -1) {
			/*
			 * this is the most imp step 
			 * that differentiates first time 
			 * from last time
			 */
			return index;
		}
		return last;
	}
}
