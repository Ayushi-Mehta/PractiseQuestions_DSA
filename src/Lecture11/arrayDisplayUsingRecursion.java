package Lecture11;

public class arrayDisplayUsingRecursion {

	public static void main(String[] args) {
		int[] arr= {10,20,30,40,50};
		int index=0;
		arrayDisplay(arr,0);
	}
	public static void arrayDisplay(int[] arr,int index) {
		if(index==arr.length) {
			return;
		}
		System.out.print(arr[index]+" ");//not arr[0] as this has to work for every recursive call
		arrayDisplay(arr,index+1);
	}
}
