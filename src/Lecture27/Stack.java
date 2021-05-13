package Lecture27;

public class Stack {
	// STACK USING ARRAY

	protected int[] data;// no new int here
	private int tos;// top of stack

	public Stack() {// constructor
		// name same as that of class ->IMP
		data = new int[5];
		tos = -1;
	}

	public Stack(int cap) {
		data = new int[cap];
		tos = -1;
	}

	public void push(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Stack is Full.");
		}
		tos++;
		data[tos] = item;
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty.");
		}
		int temp = data[tos];
		data[tos] = 0;// can be skipped
		tos--;
		return temp;
	}

	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty.");
		}
		return data[tos];
	}

	public int size() {
		return tos + 1;
	}

	public boolean isFull() {
		return size() == data.length;// or tos+1 ==data.length
	}

	public boolean isEmpty() {
		return size() == 0;// or tos==-1
	}

	public void display() {
		System.out.println();
		System.out.println("---------------------------------------");
		for (int temp = tos; temp >= 0; temp--) {
			// dont change tos here as it will loose all the values
			System.out.print(data[temp] + "\t");
		}
		System.out.println();
		System.out.println("---------------------------------------");
	}

}
