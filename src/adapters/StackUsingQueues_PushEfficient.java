package adapters;

import Lecture28.DynamicCircularQueue;

public class StackUsingQueues_PushEfficient {
	DynamicCircularQueue pq = new DynamicCircularQueue();

	public void push(int item) throws Exception {//O(1)
		try {
			pq.enqueue(item);// Exception: Queue is Full(instead of stack)
		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}
	}

	public int pop() throws Exception {//O(n)
		try {
			DynamicCircularQueue hq = new DynamicCircularQueue();

			while (pq.size() != 1) {
				hq.enqueue(pq.dequeue());
			}
			int temp;

			temp = pq.dequeue();

			pq = hq;
			return temp;
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}
	}
	
	public int peek() throws Exception{//O(n)
		try {
			DynamicCircularQueue hq = new DynamicCircularQueue();

			while (pq.size() != 1) {
				hq.enqueue(pq.dequeue());
			}
			int temp;

			temp = pq.dequeue();
			hq.enqueue(temp);
			pq = hq;
			return temp;
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}
	}
	
	public int size(){//O(1)
		return pq.size();
	}
	
	public boolean isEmpty() {//O(1)
		return pq.isEmpty();
	}
	
	public boolean isFull() {//O(1)
		return pq.isFull();
	}
	
	public void display() throws Exception {
		//display reverse in queue
		System.out.println("---------------------------");
		display(0);
		System.out.println("---------------------------");
	}

	private void display(int count) throws Exception {
		try {
		if(count==pq.size()) {
			return;
		}
		int temp=pq.dequeue();
		pq.enqueue(temp);//to maintain the order of the queue
		
		display(count+1);
		
		System.out.println(temp);
		}catch(Exception e) {
			throw new Exception("Error in Display");
		}
	}
}
