package Lecture11;

public class fibonacci {

	public static void main(String[] args) {
		int n = 10;
		int a = fibonacci(n);
		System.out.println(a);

	}

	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n==2) {
			return 1;
		}
		return fibonacci(n-2) + fibonacci(n - 1);
		
	}
}
