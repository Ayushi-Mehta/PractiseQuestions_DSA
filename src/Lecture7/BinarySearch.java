package Lecture7;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,6,7,8,9,10,55,67};
		System.out.println(binarySearch(arr, 565));
	}
	
	//O(log(base2)n)
	public static int binarySearch(int[]  arr, int item) {
		int lo=0;
		int hi=arr.length-1;
		
		while(lo<=hi) {
			int mid=(lo+hi)/2;
			if(arr[mid]<item) {
				lo=mid+1;
			}else if(arr[mid]>item) {
				hi=mid-1;
			}else {
				return mid;
			}
		}
		return -1;
	}
}
