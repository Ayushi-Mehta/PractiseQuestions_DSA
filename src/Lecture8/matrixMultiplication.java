package Lecture8;

public class matrixMultiplication {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] b = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		matrixMultiplication(a, b);
	}

	public static void matrixMultiplication(int[][] a, int[][] b) {
		boolean check = check(a, b);
		if (check) {
			int p = a.length;
			int q = b[0].length;
			int[][] res = new int[p][q];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					int sum = 0;
					for (int k = 0; k < a.length; k++) {
						sum = sum + a[i][k] * b[k][j];
					}
					System.out.print(sum + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("INVALID OPERATION");
		}
	}

	public static boolean check(int[][] a, int[][] b) {
		int i = a[0].length;
		int j = b.length;
		if (i == j) {
			return true;
		} else {
			return false;
		}
	}

}
