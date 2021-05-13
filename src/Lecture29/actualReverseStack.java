package Lecture29;

import Lecture28.DynamicStack;

public class actualReverseStack { //O(n)

	public static void main(String[] args) throws Exception {
		// 1 extra stack allowed
		// original stack data to be changed, not in the new stack ie no ref change
		DynamicStack ds = new DynamicStack();
		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(50);

		System.out.println("----------Actual Reverse----------");
		ds.display();// 50 40 30 20 10
		actualReverse(ds, new DynamicStack());
		ds.display();// 10 20 30 40 50

	}

	public static void actualReverse(DynamicStack s, DynamicStack extra) throws Exception {
		if (s.isEmpty()) {
			helperActualReverse(s, extra);
			return;
		}
		extra.push(s.pop());
		actualReverse(s, extra);

	}

	public static void helperActualReverse(DynamicStack s, DynamicStack extra) throws Exception {
		if (extra.isEmpty()) {
			return;
		}
		int temp = extra.pop();
		helperActualReverse(s, extra);
		s.push(temp);
	}
}
