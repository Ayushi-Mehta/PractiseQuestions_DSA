package Lecture30;

import Lecture28.DynamicCircularQueue;

public class QueueQuestions {

	public static void main(String[] args) throws Exception {
		DynamicCircularQueue q= new DynamicCircularQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

		q.display();
		//displayReverse(q, 0);
		actualReverse(q);
		//System.out.println();
		q.display();
	}

	
	public static void displayReverse(DynamicCircularQueue q,int count) throws Exception {
		if(q.size()==count) {
			return;
		}
		
		int temp=q.dequeue();
		q.enqueue(temp);
		
		displayReverse(q, count+1);
		
		System.out.print(temp+" ");
		
	}

	public static void actualReverse(DynamicCircularQueue q) throws Exception {
		if(q.isEmpty()) {
			return;
		}
		
		int temp= q.dequeue();
		actualReverse(q);
		q.enqueue(temp);
		
	}
}
