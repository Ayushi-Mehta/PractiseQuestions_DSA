package Lecture11;

public class recursionPractise {

	public static void main(String[] args) {
		int n = 5;
		PD(n);
		System.out.println("-----------------");
		PI(n);
		System.out.println("-----------------");
		P(n);
		System.out.println("-----------------");
	}

	public static void PD(int n) {// PD=print decreasing
		if (n == 1) {
			System.out.println(n);
			return;// dont return a number here!!!!
		}
		System.out.println(n);// first print 5
		PD(n - 1);// then do the smaller problem for uptil 4
		// smaller problem: n-1 to 1 dec printed
	}

	public static void PI(int n) {// PI=print increasing
		if (n == 1) {
			System.out.println(n);
			return;
		}
		PI(n - 1);// first do the smaller problem for uptil 4
		System.out.println(n);// prints 5 at the end
	}
	public static void P(int n) {
		if(n==0) {
			return;
		}
		System.out.println(n);
		P(n-1);
		System.out.println(n);
	}
}
