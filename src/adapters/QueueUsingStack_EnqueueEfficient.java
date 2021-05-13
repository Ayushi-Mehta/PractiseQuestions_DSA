package adapters;

import Lecture28.DynamicStack;

public class QueueUsingStack_EnqueueEfficient {

	DynamicStack ps = new DynamicStack();

	public void enqueue(int item) throws Exception {// O(1)
		try {
			ps.push(item);
		} catch (Exception e) {
			throw new Exception("Queue is Full.");
		}
	}

	public int dequeue() throws Exception {// O(n)
		try {
			DynamicStack hs = new DynamicStack();

			while (ps.size() != 1) {
				hs.push(ps.pop());
			}

			int temp = ps.pop();

			while (hs.size() != 0) {
				ps.push(hs.pop());
			}
			return temp;
		} catch (Exception e) {
			throw new Exception("Queue is Full.");
		}
	}

	public int getFront() throws Exception {// O(n)
		try {
			DynamicStack hs = new DynamicStack();

			while (ps.size() != 1) {
				hs.push(ps.pop());
			}

			int temp = ps.pop();
			hs.push(temp);
			while (hs.size() != 0) {
				ps.push(hs.pop());
			}

			return temp;
		} catch (Exception e) {
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

	public void display() throws Exception {
		System.out.println("--------------------------");
		displayH();
		System.out.println("--------------------------");
	}

	public void displayH() throws Exception {// O(n)
		try {
			if (ps.isEmpty()) {
				return;
			}
			int temp = ps.pop();

			displayH();

			System.out.println(temp);
			ps.push(temp);
		} catch (Exception e) {
			throw new Exception("Error in Display.");
		}
	}
}
