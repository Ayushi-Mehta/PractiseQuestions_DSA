package Lecture31;

public class LinkedList {// (outer class)

	private class Node {// nested class(inner class)
		public Node(int i) {
			data = i;
		}

		public Node() {
			data = 0;
			next = null;
		}

		// made private as node class should only be used in linked list and not
		// anywhere else
		int data;
		Node next;
	}

	private Node head;// head stores address which is storing an entire node

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

	public int getFirst() throws Exception {// O(1)
		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}
		return head.data;
	}

	public int getLast() throws Exception {// O(n)
		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}
		Node temp = head;
		while (temp.next != null) {// last node
			temp = temp.next;
		}
		return temp.data;
	}

	public int getAt(int index) throws Exception {// O(n)
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

	public void addLast(int item) {// O(n)
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

	public void addFirst(int item) {// O(1)
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

	public void addAt(int index, int item) throws Exception {// O(n)
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

	public int removeLast() throws Exception {// O(n)
		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}
		int rv = getLast();
		if (size() == 1) {
			head = null;
		} else {
			Node lastSecond = getNodeAt(size() - 2);
			lastSecond.next = null;
		}
		return rv;
	}

	public int removeFirst() throws Exception {// O(1)
		if (isEmpty()) {
			throw new Exception("LL is Empty");
		}
		int rv = getFirst();
		// if (size() == 1) {
		// head = null;
		// } else {
		// head = head.next;
		// }
		head = head.next;
		return rv;
	}

	public int removeAt(int index) throws Exception {// O(n)
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

	public void reverseI() {
		// Node prev=head;
		// Node curr= head.next;

		Node prev = null;
		Node curr = head;

		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;// curr==curr.next
		}

		// head.next= null; //old first node, now last node has next=null
		head = prev;// new head will be the last node which at the end prev would land on
	}

	public void reverseR() {
		// reverseR(null, head);

		Node temp = head;
		reverseR(head);
		temp.next = null;
	}

	private void reverseR(Node prev, Node curr) {
		if (curr == null) {
			head = prev;
			return;
		}

		// reverseR(curr, ahead);
		reverseR(curr, curr.next);

		// Node ahead= curr.next;
		curr.next = prev;
	}

	private void reverseR(Node curr) {
		if (curr.next == null) {
			head = curr;
			return;
		}

		// reverseR(curr, ahead);
		reverseR(curr.next);

		// Node ahead= curr.next;
		curr.next.next = curr;
	}

	public void reverseData() throws Exception {
		int left = 0;
		int right = this.size() - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			// swapping data
			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;
		}
	}

	public int mid() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {// write in this order only
			// otherwise null pointer exception aa jaegi
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public int KthFromLast(int k) {
		Node fast = head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		Node slow = head;

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;
	}

	public int intersection() {
		// createDummyList
		// create new nodes for all nodes of both the LL
		// create dummy list function with an intersection point
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		Node n10 = new Node(100);
		Node n11 = new Node(110);
		Node n12 = new Node(120);
		Node n13 = new Node(130);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n3;
		n9.next = n10;
		n13.next = n12;
		n12.next = n11;
		n11.next = n7;

		Node h1 = n1;
		Node h2 = n13;

		// logic..
		return intersection(h1, h2);
	}

	private int intersection(Node h1, Node h2) {
		Node fp = h1;
		Node sp = h2;

		while (fp != sp) {
			if (fp == null) {
				fp = h2;
			} else {
				fp = fp.next;
			}
			if (sp == null) {
				sp = h1;
			} else {
				sp = sp.next;
			}
		}
		return fp.data;
	}

	public void kReverse(int k) {
		head = kReverse(head, k);
	}

	private Node kReverse(Node node, int k) {
		// base case
		if (node == null) {
			return null;
		}

		// to identify the argument of smaller problem
		Node temp = node;
		for (int i = 1; i <= k && temp != null; i++) {
			temp = temp.next;
		}

		// smaller problem: reverse set 2 and 3
		Node prev = kReverse(temp, k);

		// self work:reverse set 1
		// reverse pointer iteratively
		Node curr = node;
		while (curr != temp) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		return prev;
	}

	// FLOYD CYCLE DETECTION ALGORITHM
	public void createdummylistDetectLoop() {
		// createDummyList
		// create new nodes for all nodes of both the LL
		// create dummy list function with an intersection point
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n3;

		// logic..
		System.out.println(detectLoop(n1));
	}

	private boolean detectLoop(Node h1) {
		Node slow = h1;
		Node fast = h1;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				// removeLoop(slow,h1);
				removeLoop2(slow, h1);
				return true;
			}
		}
		return false;
	}

	// O(n)
	public void removeLoop(Node meet, Node h) {
		// no. of nodes in loop
		Node temp = meet;
		int count = 1;
		while (temp.next != meet) {
			temp = temp.next;
			count++;
		}

		// move a pointer count distance ahead
		Node fast = h;
		for (int i = 1; i <= count; i++) {
			fast = fast.next;
		}

		// make slow and fast move at same speed
		Node slow = h;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}

		// break loop
		fast.next = null;

		// print ll
		Node t = h;
		while (t != null) {
			System.out.print(t.data + " ");
			t = t.next;
		}
	}

	// FLOYD CYCLE REMOVAL ALGORITHM
	public void removeLoop2(Node meet, Node h) {
		Node start = h;
		Node loop = meet;

		while (start.next != loop.next) {
			start = start.next;
			loop = loop.next;
		}

		loop.next = null;

		// print ll
		Node t = h;
		while (t != null) {
			System.out.print(t.data + " ");
			t = t.next;
		}
	}

}
