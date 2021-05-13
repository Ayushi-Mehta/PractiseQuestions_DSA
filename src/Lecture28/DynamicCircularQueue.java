package Lecture28;

import Lecture27.CircularQueue;

public class DynamicCircularQueue extends CircularQueue {

	/*
	 * means that it will check whether the parent class definitely has the same
	 * function and that you are overriding it for sure and not creating another
	 * function
	 */

	@Override // ANNOTATION USED TO OVERRIDE
	public void enqueue(int item) throws Exception {
		if (isFull()) {
			// creating new array
			int[] na = new int[data.length * 2];

			// copying elements
			for (int i = 0; i < size; i++) {
				int index = (i + front) % data.length;
				na[i] = data[index];
			}
			// ref changed and front made to zero
			data = na;
			front = 0;
		}
		super.enqueue(item);
	}
}
