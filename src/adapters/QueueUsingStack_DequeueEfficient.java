package adapters;

import Lecture28.DynamicStack;

public class QueueUsingStack_DequeueEfficient {

	DynamicStack ps= new DynamicStack();
	
	public int dequeue() throws Exception {//O(1)
		try {
			return ps.pop();
		}catch(Exception e) {
			throw new Exception("Queue is Empty.");
		}
	}
	
	public int getFront() throws Exception {//O(1)
		try {
			return ps.peek();
		}catch(Exception e) {
			throw new Exception("Queue is Empty.");
		}
	}
	
	public void enqueue(int item) throws Exception {//O(n)
		try {
		DynamicStack hs= new DynamicStack();
		
		while(ps.size()!=0) {
			hs.push(ps.pop());
		}
		
		hs.push(item);
		
		while(hs.size()!=0) {
			ps.push(hs.pop());
		}
		}catch(Exception e) {
			throw new Exception("Queue is Full.");
		}
	}
	
	public int size() {// O(1)
		return ps.size();
	}

	public boolean isEmpty() {// O(1)
		return ps.isEmpty();
	}

	public boolean isFull() {// O(1)
		return ps.isFull();
	}
	
	public void display() {//O(n)
		ps.display();
	}
}
