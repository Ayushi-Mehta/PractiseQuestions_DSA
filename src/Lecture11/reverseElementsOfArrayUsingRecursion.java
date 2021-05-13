package Lecture11;

public class reverseElementsOfArrayUsingRecursion {

	public static void main(String[] args) {
		int[] arr= {10,20,30,40,50};
		
		reverseArray(arr,0);

	}
	public static void reverseArray(int[] arr, int index) {
		if(index==arr.length) {
			return;
		}
		reverseArray(arr,index+1);
		System.out.println(arr[index]);// call created at the end
	}

}
