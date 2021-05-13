package Lecture27;

public class Queue {

	private int[] data;
	private int front;
	private int size;

	public Queue() {
		data = new int[5];
		front = 0;
		size = 0;
	}

	public Queue(int cap) {
		data = new int[cap];
		front = 0;
		size = 0;
	}

	public void enqueue(int item) {
		int index = front + size;
		data[index] = item;

		size++;
	}

	public int dequeue() {
		int temp = data[front];
		data[front] = 0;
		front = front + 1;// DONT WRITE FRONT++ AS % DATA.LENGTH NAI HOTA LOL!!!IMPORTANT!!
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
		for(int i=front; i<front+size;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		System.out.println("--------------------------");
	}
	
}
