package Lecture48;

public class Odd_Even {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (Odd(8)) {
			System.out.println("Odd");
		} else {
			System.out.println("even");
		}
	}

	public static boolean Odd(int n) {
		if ((n & 1) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
