package Lecture31;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		// list.display();
		list.addFirst(40);
		list.addFirst(50);
		// list.display();
		list.addAt(4, 100);
		list.display();
		list.removeLast();
		// list.display();
		// list.removeFirst();
		// list.display();
		// list.removeAt(2);
		// list.display();

		// System.out.println(list.getFirst());
		// System.out.println(list.getLast());
		// System.out.println(list.getAt(3));

		// list.display();

		list.reverseI();
		list.display();

		list.reverseR();
		list.display();
		
		System.out.println(list.mid());
		list.display();
		
		System.out.println(list.KthFromLast(2));
		System.out.println(list.KthFromLast(4));
		
		list.display();
		list.reverseData();
		list.display();
	}

}
