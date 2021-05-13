package Lecture8;

public class waveDisplay {

	public static void main(String[] args) {
		int[][] a= {{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25},{26,27,28,29,30}};
		waveArray(a);
	}
	public static void waveArray(int[][] a) {
		for(int col=0;col<a[0].length;col++) {
			if(col%2==0) {
				for(int row=0;row<a.length;row++) {
					System.out.print(a[row][col]+" ");
				}
			}
			else {
				for(int row=a.length-1;row>=0;row--) {
					System.out.print(a[row][col]+" ");
				}
			}
			
		}
	}
}
