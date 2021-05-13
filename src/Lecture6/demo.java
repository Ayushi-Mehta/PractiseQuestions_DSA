package Lecture6;

public class demo {

	public static void main(String[] args) {
		int[] one= {10,20,30,40,50};//hardcoded values of array
		int[] two= {100,200,300};
		/* 
		 * eg
		 * one=2k->a1 is reference to the array being created at 2k memory address
		 * two=3k
		 */
		System.out.println(one[0]+" "+two[0]);
		swap(one[0],two[0]);
		System.out.println(one[0]+" "+two[0]);
		
		//System.out.println(one[0]+" "+two[0]);
		//swap(one,two,0);
		//System.out.println(one[0]+" "+two[0]);
		
		System.out.println(one[0]+" "+two[0]);
		swap(one,two);
		System.out.println(one[0]+" "+two[0]);
	}
	public static void swap(int a,int b) {//sirf array ki ek int value share kri
		int temp=a;//temp is int because a is also an int 
		a=b;//had temp been an array, usme address store krwana padta
		b=temp;
		/*as the function terminates, the variables get destroyed 
		 * and the array values remain the same
		 */
	}
	/* the values were changed in variables a and b
	 * they were not changed in the array itself
	 * so when we print out one[0] and two[0] they are still the same
	 * and variables a and b swapped their values 
	 */
	public static void swap(int[] a,int[] b,int i) {//int[] used because an array is being shared 
		//a=2k,b=3k,i=0
		/*2k is an int rather than an array
		 * thus temp has to be int rather than an array 
		 */
		int temp=a[i];//a[i] is int rather than array or its address
		//temp,a,b,i is local to this function in stack
		a[i]=b[i];//changes took place in heap memory in original array
		b[i]=temp;
	}
	public static void swap(int[] a,int[] b) {//pura array share kra
		int[] temp=a;//temp here only stores the address of an array
		//a=2k,b=3k
		a=b;//changes only in local variable in stack and not in heap
		b=temp;
	}//swapping nai hogi isme

}
