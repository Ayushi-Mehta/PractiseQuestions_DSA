package adapters;

public class QUS_EnqueueEfficient_Client {

	public static void main(String[] args) throws Exception {
		
		QueueUsingStack_EnqueueEfficient queue=new QueueUsingStack_EnqueueEfficient();
		
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
