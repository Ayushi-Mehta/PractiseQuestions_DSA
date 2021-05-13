package Lecture9;

import java.util.ArrayList;

public class arrayListDemo {

	public static void main(String[] args) {
		//create a new ArrayList
		ArrayList<Integer> list = new ArrayList<Integer>();
		//import package using ctrl+space
		
		//size
		System.out.println(list.size());
		
		//print
		System.out.println(list);
		
		//add
		list.add(10);
		list.add(20);
		list.add(30);
		System.out.println(list.size());
		System.out.println(list);
		
		list.add(1,50);
		System.out.println(list.size());
		System.out.println(list);
		
		list.add(3,100);
		System.out.println(list.size());
		System.out.println(list);
		
		//get->to just get the value at a particular index
		System.out.println(list.get(2));
		
		//obtain value at the last index
		System.out.println(list.get(list.size()-1));
		
		
		//set->used to change already existing value in the list
		
		list.set(2, 70);
		System.out.println(list);
		
		//updating value at last index
		list.set(list.size()-1,200);
		System.out.println(list);
		
		//remove
		list.remove(2);
		System.out.println(list);
		
		//print->for loop/enhanced can also be used
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
			//printing without  "[]"
		}
		System.out.println();
		//enhanced
		for( int val : list) {
			System.out.print(val+" ");
		}
		
		
		
	}

}
