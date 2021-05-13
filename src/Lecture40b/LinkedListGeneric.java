package Lecture40b;


public class LinkedListGeneric<T> {// (outer class)

	private class Node {// nested class(inner class)
		// made private as node class should only be used in linked list and not
		// anywhere else
		T data;
		Node next;
	}

	private Node head;// head stores address which is storing an entire node
	private int size;

	public void display() {// O(n)
		Node temp = head;// i=0
		System.out.println("----------------------");
		while (temp != null) {// i<arr.length
			System.out.print(temp.data + " ");
			temp = temp.next;// i++
		}
		System.out.println(".");
		System.out.println("----------------------");
	}

	public int size() {// O(n)
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public boolean isEmpty() {// O(1)
		return head == null;
	}

	public T getFirst() throws Exception {// O(1)
		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}
		return head.data;
	}

	public T getLast() throws Exception {// O(n)
		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}
		Node temp = head;
		while (temp.next != null) {// last node
			temp = temp.next;
		}
		return temp.data;
	}

	public T getAt(int index) throws Exception {// O(n)
		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}

		if (index < 0 || index > size() - 1) {
			throw new Exception("Index Invalid");
		}

		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	private Node getNodeAt(int index) throws Exception {// O(n)
		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}

		if (index < 0 || index > size() - 1) {
			throw new Exception("Index Invalid");
		}

		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void addLast(T item) {// O(n)
		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		if (isEmpty()) {
			head = nn;
		} else {

			// move to the last node
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}

			// Node temp=getNodeAt(size()-1);
			// linking
			temp.next = nn;
		}
	}

	public void addFirst(T item) {// O(1)
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (isEmpty()) {

		} else {
			nn.next = head;// linking

			// head updated as we have done addition at start
			head = nn;
		}
	}

	public void addAt(int index, T item) throws Exception {// O(n)
		if (index < 0 || index > size()) {
			throw new Exception("Invalid Index.");
		}
		if (index == 0) {
			addFirst(item);
		} else if (index == size()) {
			addLast(item);
		}

		else {
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// linking
			Node nm1 = getNodeAt(index - 1);
			Node np1 = getNodeAt(index);

			nm1.next = nn;
			nn.next = np1;
		}
	}

	public T removeLast() throws Exception {// O(n)
		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}
		T rv = getLast();
		if (size() == 1) {
			head = null;
		} else {
			Node lastSecond = getNodeAt(size() - 2);
			lastSecond.next = null;
		}
		return rv;
	}

	public T removeFirst() throws Exception {// O(1)
		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}
		T rv = getFirst();
		// if (size() == 1) {
		// head = null;
		// } else {
		// head = head.next;
		// }
		head = head.next;
		return rv;
	}

	public T removeAt(int index) throws Exception {// O(n)
		if (index < 0 || index > size()) {
			throw new Exception("Invalid Index.");
		}
		if (index == 0) {
			return removeFirst();
		} else if (index == size() - 1) {
			return removeLast();
		} else {
			Node nm1 = getNodeAt(index - 1);
			Node n = getNodeAt(index);// n=nm1.next
			Node np1 = getNodeAt(index + 1);// np1=n.next

			nm1.next = np1;

			return n.data;
		}
	}

	
	
}
