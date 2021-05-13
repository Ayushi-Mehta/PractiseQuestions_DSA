package Lecture27;

public class CircularQueueClient {

	public static void main(String[] args) throws Exception {
		CircularQueue q = new CircularQueue();

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(60);
		q.enqueue(70);
		q.enqueue(80);
		q.display();
	}

}
