package Lecture8;

public class spiralDisplay {

	public static void main(String[] args) {
		int[][] a = { { 11, 12, 13, 14 }, { 15, 16, 17, 18 }, { 19, 20, 21, 22 } };
		spiralDisplay(a);
	}

	public static void spiralDisplay(int[][] a) {
		int minrow = 0;
		int maxrow = a.length - 1;
		int mincol = 0;
		int maxcol = a[0].length - 1;
		int count = 0;// no of elements printed till now
		int m = a.length;
		int n = a[0].length;
		int total = m * n;// safest way to run the loop
		while (count < total) {// count!=total since it is post incremented
			for (int i = minrow; i <= maxrow && count < total; i++) {
				System.out.print(a[i][mincol] + " ");
				count++;
			}
			mincol++;
			for (int j = mincol; j <= maxcol && count < total; j++) {
				System.out.print(a[maxrow][j] + " ");
				count++;
			}
			maxrow--;
			for (int i = maxrow; i >= minrow && count < total; i--) {
				System.out.print(a[i][maxcol] + " ");
				count++;
			}
			maxcol--;
			for (int j = maxcol; j >= mincol && count < total; j--) {
				System.out.print(a[minrow][j] + " ");
				count++;
			}
			minrow++;
		}
	}
}
/*
 *" && count < total" added in every for loop so that 
 *the next two for loops are not implemented 
 *to save run time since loop will break 
 *the moment all the no.s are printed
 *
 *otherwise all four loops will still run 
 *and take up more run time
 *even though they wont print anything
 *due to the values of mincol,minrow,maxcol,maxrow 
 *becoming negative
 */
