package Lecture29;

import Lecture28.DynamicStack;

public class reverseStack {

	public static void main(String[] args) throws Exception { //O(n)
		// reverse display
		// stack content should remain the same
		// no extra stack can be created

		DynamicStack ds = new DynamicStack();
		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(50);

		System.out.println("----------Display Reverse----------");
		ds.display();// 50 40 30 20 10
		displayReverse(ds);
		ds.display();// 50 40 30 20 10 : stack content is still the same
	}

	public static void displayReverse(DynamicStack s) throws Exception {
		if (s.isEmpty()){
			return;
		}
		int temp = s.pop();
		displayReverse(s);
		
		System.out.print(temp+" ");
		s.push(temp);
	}
}
