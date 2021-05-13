package adapters;

public class QUS_DequeueEfficient_Client {

	public static void main(String[] args) throws Exception {
		QueueUsingStack_DequeueEfficient queue = new QueueUsingStack_DequeueEfficient();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();
		System.out.println(queue.dequeue());
		queue.display();
		System.out.println(queue.getFront());

	}

}
