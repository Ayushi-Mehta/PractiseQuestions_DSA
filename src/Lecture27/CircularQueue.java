package Lecture27;

public class CircularQueue {

	protected int[] data;
	protected int front;
	protected int size;

	public CircularQueue() {
		data = new int[5];
		front = 0;
		size = 0;
	}

	public CircularQueue(int cap) {
		data = new int[cap];
		front = 0;
		size = 0;
	}

	public void enqueue(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Queue is Full.");
		}
		int index = (front + size) % data.length;// DIFFERENCE FROM NORMAL QUEUE
		data[index] = item;

		size++;
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty.");
		}
		int temp = data[front];
		data[front] = 0;
		front = (front + 1) % data.length;// DIFFERENCE FROM NORMAL QUEUE
		// DONT WRITE FRONT++ !!!IMPORTANT!!
		size--;// IMPORTANT!!
		return temp;
	}

	public int getFront() {
		int temp = data[front];
		return temp;
	}

	public int size() {
		return size;// variable size
	}

	public boolean isFull() {
		return size == data.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void display() {
		System.out.println("--------------------------");
		for (int i = 0; i < size; i++) {
			int index = (i + front)%data.length;
			System.out.print(data[index]+ " ");
		}
		System.out.println();
		System.out.println("--------------------------");
	}
}
