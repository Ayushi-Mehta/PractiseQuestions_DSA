package Lecture24;

public class TimeComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// polynomial(7,3);
		// polynomial_NSquare(7, 3);
		// int k = Power(3, 2);
		// System.out.println(k);
		// int a = PowerNby2(3, 2);
		//boolean a = isPrimeMostEff(73);
		//System.out.println(a);
	}

	public static void polynomial(int n, int x) {
		int ans = 0;
		int a = x;
		for (int i = 1; i <= n; i++) {
			ans += (n - i + 1) * a;
			a = a * x;
		}
		System.out.println(ans);
	}

	public static void polynomial_NSquare(int n, int x) {
		int limit = n;
		int sum = 0;
		for (int coeff = 1; coeff <= n; coeff++) {
			int multi = 1;
			for (int i = 1; i <= limit; i++) {
				multi = multi * i;
			}
			sum = sum + coeff * multi;
		}
		System.out.println(sum);
	}

	public static void polynomial1(int n, int x) {
		int sum = 0;
		int multi = 1;
		for (int i = 1; i <= n; i++) {// x^n
			multi = multi * x;
		}
		for (int coeff = 1; coeff <= n; coeff++) {
			sum += coeff * multi;
			multi = multi / x;
		}
		System.out.println(sum);
	}

	public static void polynomial2(int n, int x) {
		int sum = 0;
		int multi = (int) Math.pow(x, n);// time complexity=logn
		for (int coeff = 1; coeff <= n; coeff++) {
			sum += coeff * multi;
			multi = multi / x;
		}
		System.out.println(sum);
		// net time complexity=n+logn
		// O(n)
	}

	public static void polynomial3(int n, int x) {
		int sum = 0;
		int multi = x;// time complexity=logn
		for (int coeff = n; coeff >= 1; coeff--) {
			sum += coeff * multi;
			multi = multi * x;
		}
		System.out.println(sum);
		// net time complexity=n+logn
		// O(n)
	}

	public static int Power(int n, int x) {
		if (n == 0) {
			return 1;
		}
		return Power(n - 1, x) * x;
		// O(n)
	}

	public static int PowerNby2(int n, int x) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			return PowerNby2(n / 2, x) * PowerNby2(n / 2, x);
		} else {
			return PowerNby2(n / 2, x) * PowerNby2(n / 2, x) * x;
		}
		// O(n) becuase of so many calls being given
	}

	public static int PowerNby2LessSpace(int n, int x) {
		// fastest way to compute x^n=O(logn)
		// FAST EXPONENTIATION ALGORITHM
		if (n == 0) {
			return 1;
		}
		int sp = PowerNby2LessSpace(n / 2, x);
		// SP pnlu calculated once rather than calculating the same thing many times
		if (n % 2 == 0) {
			return sp * sp;
		} else {
			return sp * sp * x;
		}
		// O(logn) ie <O(n)
	}

	public static boolean isPrime(int n) {
		/*
		 * 1 to n->O(n) 2 to n-1 ->O(n) 2 to n/2 ->O(n) 2 to n^0.5 ->O(n^0.5) -->BEST!!
		 */
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrimeMostEff(int n) {// O(n^0.5)----MOST EFFICIENT
		for (int i = 2; i < Math.pow(n, 0.5); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
