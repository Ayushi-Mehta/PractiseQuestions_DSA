package Lecture9;

import java.util.ArrayList;

public class intersection {

	public static void main(String[] args) {
		//both arrays are sorted in increasing order
		int[] one= {10,10,20,30,30,30,50,70,70};
		int[] two= {30,30,50,60,60,70,70,70,80,90,100};
		//size can be different
		
		ArrayList<Integer> list = new ArrayList<>();
		/*
		 * arraylist used here 
		 * because size need not be mentioned
		 * at the beginning
		 * and values can be added whenever user wants
		 */
		/*for(int val :one) {
			for(int same : two) {
				if(val==same) {
					list.add(val);
				}
			}
		}
		*/
		
		/*int j=0;
		for(int i=0;i<one.length;i++) {
			if(one[i]==two[j]) {
				list.add(one[i]);
				j++;
			}
			else if(one[i]>two[j]) {
				j++;
				if(one[i]==two[j]) {
					list.add(one[i]);
					j++;
					if(one[i]==two[j]) {
						list.add(one[i]);
						j++;
					}
				}
			}
			
		}
		*/
		
		//TWO POINTER APPROACH->only for inc. sorted array
		int i=0;//one
		int j=0;//two
		
		while(i!=one.length && j!=two.length) {
			if(one[i]<two[j]) {
				i++;
			}
			else if(one[i]>two[j]) {
				j++;
			}
			else {
				list.add(one[i]);
				i++;
				j++;
			}
		}
		
		for( int k :list) {
			System.out.print(k+" ");
		}

	}

	//O(n+m)
	
}
