package Lecture11;

public class allIndexes {

	public static void main(String[] args) {
		int[] arr = { 10, 2, 90, 80, 90 };
		int element = 90;
		int[] rr=allIndex(arr,0,element,0);
		for(int val:rr) {
			System.out.print(val+" ");
		}
	}
	public static int[] allIndex(int[] arr,int index, int element, int count) {
		if(index==arr.length){
	
			int[] br=new int[count];
			return br;
		}
		int[] rr;
		if(arr[index]==element){
			rr = allIndex(arr,index+1,element,count+1);
			rr[count]=index;
		}
		else {
			rr = allIndex(arr,index+1,element,count);
		}
		return rr;
	}
}
