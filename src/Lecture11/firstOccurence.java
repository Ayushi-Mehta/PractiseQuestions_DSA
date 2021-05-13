package Lecture11;

public class firstOccurence {

	public static void main(String[] args) {
		int[] arr= {10,2,90,80,60};
		int element= 90;
		System.out.println(firstTime(arr,0,element));
	}
	public static int firstTime(int[] arr, int index, int element) {
		if(arr[index]==element) {
			return index;
		}
		else if(index == arr.length-1) {
			return -1;
		}
		return firstTime(arr,index+1,element);
	}
}
