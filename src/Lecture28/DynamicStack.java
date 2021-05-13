package Lecture28;

import Lecture27.Stack;

public class DynamicStack extends Stack {

	public void push(int item) throws Exception {
		if (isFull()) {
			
			//create a new array of double size
			int[] na = new int[data.length * 2];
			// error as the variable was made private, make protected

			//copying values
			for (int i = 0; i < data.length; i++) {
				na[i] = data[i];
			}
			//ref change
			data = na;
		}
		super.push(item);
		//super is a keyword to refer to the parent class ie stack here
		//DO NOT write only push here, it will cause an infinite recursion
	}
}
