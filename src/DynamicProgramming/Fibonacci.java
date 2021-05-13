package DynamicProgramming;

public class Fibonacci {

	public static void main(String[] args) {
		//System.out.println(FibRecursion(5));
		int n=100000;
		//System.out.println(FibTopDownDP(n,new int[n+1]));
		//System.out.println(FibBottomUpDP(n));
		System.out.println(FibBottomUpDP_SpaceEff(n));
	}
	//O(2^n),S(O(rec extra space))
	public static int FibRecursion(int n) {
		if(n==0||n==1) {
			return n;
		}
		
		int fm1=FibRecursion(n-1);
		int fm2=FibRecursion(n-2);
		int fn=fm1+fm2;
		return fn;
	}

	//O(n) S(O(n+rec extra space))
	public static int FibTopDownDP(int n,int[] storage) {
		//fails when number is so large that it gives stack overflow error
		if(n==0||n==1) {
			return n;
		}
		if(storage[n]!=0) {
			return storage[n];//re-use
		}
		int fm1=FibTopDownDP(n-1,storage);
		int fm2=FibTopDownDP(n-2,storage);
		
		int fn=fm1+fm2;
		
		storage[n]=fn;//storing recursively
		
		return fn;
	}
	
	/*
	 * for bottom up approach, we will fill the same array iteratively
	 */
	/*
	 * for bottom up, take care of these things-
	 * 1-Meaning of each cell of array
	 * 2-Array size
	 * 3-Direction of filling the array
	 * 4-Base cases of top down to be filled before hand
	 * and the array to store all values before you start 
	 * the work of bottom up approach
	 */
	
	//O(n),S(O(n))
	public static int FibBottomUpDP(int n) {
		//arr of size n+1
		int[] storage=new int[n+1];
		
		//base case values fill
		storage[0]=0;
		storage[1]=1;
		
		//filling ki direction
		for(int i=2;i<=n;i++) {
			storage[i]=storage[i-1]+storage[i-2];
		}
		
		return storage[n];
	}
	
	//O(n),S(O(1))
	public static int FibBottomUpDP_SpaceEff(int n) {
		int[] storage=new int[2];
		storage[0]=0;
		storage[1]=1;
		
		for(int slide=1;slide<=n-1;slide++) {
			int sum=storage[0]+storage[1];
			storage[0]=storage[1];
			storage[1]=sum;
		}
		
		return storage[1];
	}
}
