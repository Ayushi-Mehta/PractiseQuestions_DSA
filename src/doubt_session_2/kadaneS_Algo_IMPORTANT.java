package doubt_session_2;

public class kadaneS_Algo_IMPORTANT {

	public static void main(String[] args) {
		/*
		 * subarrays ques 
		 * print all subarrays
		 * sum og each subarray
		 * max sum of all subarrays
		 * 3 or 2 loops ->O(n^2)
		 * 
		 * kadane's algo does the same thing in 1 loop ie O(n)!!!
		 * tells max sum of subarray
		 *
		 */
		int[] ar= {2,3,-6,1,2,3,-4,5,-10,6};
		System.out.println(kadane(ar));
		//max sum subarray=[1,2,3,-4,5]=7
		//either add to existing group or form new group
		
	}
	public static int kadane(int[] arr) {
		int sum=arr[0];
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			sum= Math.max(sum+arr[i], arr[i]);
		}
		if(sum>max) {
			max=sum;
		}
		return max;
	}
}
