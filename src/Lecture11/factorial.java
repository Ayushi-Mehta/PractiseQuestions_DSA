package Lecture11;

public class factorial {

	public static void main(String[] args) {
		int n=5;
		int a=factorial(n);
		System.out.println(a);

	}
	public static int factorial(int n) {
		if(n==1) {
			return 1;
		}
		int ans =n*factorial(n-1);
		return ans;
	}
}
