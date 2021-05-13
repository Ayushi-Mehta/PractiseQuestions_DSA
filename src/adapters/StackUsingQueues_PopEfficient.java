package adapters;

import Lecture28.DynamicCircularQueue;

public class StackUsingQueues_PopEfficient {
	DynamicCircularQueue pq=new DynamicCircularQueue();
	
	public void push(int item) throws Exception {//O(n)
		try {
		DynamicCircularQueue hq= new DynamicCircularQueue();
		hq.enqueue(item);
		
		while(pq.size()!=0) {
			hq.enqueue(pq.dequeue());
		}
		pq=hq;
		}catch(Exception e) {
			throw new Exception("Stack is Full.");
		}
	}
	
	public int pop() throws Exception {//O(1)
		try {
			return pq.dequeue();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}
	}
	
	public int peek() throws Exception {//O(1)
		try {
			return pq.getFront();
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
	
	public void display() {//O(n)->all elements being displayed
		pq.display();
	}
	
	
	
	
	
	
	
	
	
}
