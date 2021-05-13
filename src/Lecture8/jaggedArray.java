package Lecture8;

public class jaggedArray {//USED TO SAVE SPACE

	public static void main(String[] args) {
		int[][] jarr= new int[3][];
		//can be stored like this, leaving col empty
		//vice versa not possible
		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);
		
		jarr[0]=new int[5];
		jarr[1]=new int[3];
		jarr[2]=new int[6];
		
		//MAKES VARIABLE ROW LENGTH ARRAY
		
		for(int[] i:jarr) {
			for(int val:i) {
				System.out.print(val);
			}
			System.out.println();
		}
		
		
		for(int i=0;i<jarr.length;i++) {
			int count=0;
			for(int j=0;j<jarr[i].length;j++) {
				/*
				 * here arr[0].length doesnt work
				 * because every row is of variable length
				 */
				count++;
			}
			System.out.println(count);
		}
		
		
	}
}
