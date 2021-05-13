package Lecture11;

public class arrayMaxUsingRecursion {

	public static void main(String[] args) {
		int[] arr= {10,2,90,80,60};
		System.out.println(arrayMax(arr,0));

	}
	public static int arrayMax(int[] arr,int index) {
		if(index==arr.length-1) {
			return arr[index];
		}
		int maxTillNow= arrayMax(arr,index+1);
		int maxTotal = Math.max(maxTillNow,arr[index]);
		return maxTotal;
	}
}
