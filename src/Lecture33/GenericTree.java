package Lecture33;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		root = construct(null, -1);// very imp to store in root
	}

	private Node construct(Node parent, int ith) {

		// prompt
		if (parent == null) {
			System.out.println("Enter the data for root node ");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data + " ? ");
		}

		// take input of data
		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();

		// update the data
		nn.data = item;

		// prompt
		System.out.println("Enter the number of children for " + nn.data + " ?");

		// take input for children
		int noc = scn.nextInt();

		// loop
		for (int j = 0; j < noc; j++) {
			Node child = construct(nn, j);
			nn.children.add(child);// nn.children=arraylist , (nn.children).add=arraylist.add

		}

		return nn;
	}

	public void display() {
		System.out.println("-------------------");
		display(root);
		System.out.println("-------------------");
	}

	private void display(Node node) {
		// self work
		String str = node.data + "->";
		for (Node child : node.children) {// enhanced loop
			str += child.data + " ";
		}
		str += ".";
		System.out.println(str);

		// samller problem
		for (Node child : node.children) {// enhanced loop
			display(child);// recursive call
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		int ts = 0;
		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}
		return ts + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int tm = node.data;

		for (Node child : node.children) {
			int cn = max(child);

			if (cn > tm) {
				tm = cn;
			}
		}

		return tm;
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {
		if (node.data == item) {
			return true;
		}
		for (Node child : node.children) {
			boolean cf = find(child, item);
			if (cf) {
				return true;
			}
		}
		return false;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int th = -1;
		for (Node child : node.children) {
			int ch = height(child);
			if (ch > th) {
				th = ch;
			}
		}
		return th + 1;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		// smaller prob
		for (Node child : node.children) {
			mirror(child);
		}

		// work
		int i = 0;
		int j = node.children.size() - 1;
		while (i < j) {
			Node in = node.children.get(i);
			Node jn = node.children.get(j);

			node.children.set(i, jn);
			node.children.set(j, in);

			i++;
			j--;
		}
	}

	public void printAtLevel(int level) {
		printAtLevel(root, level, 0);
	}

	private void printAtLevel(Node node, int level, int count) {
		if (count == level) {
			System.out.print(node.data + " ");
			return;
		}
		for (Node child : node.children) {
			printAtLevel(child, level, count + 1);
		}
	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {//IMPORTANT QUESTION!!

		for (Node child : node.children) {
			linearize(child);
		}
		while (node.children.size() > 1) {
			Node temp = node.children.remove(1);
			Node tail = getTail(node.children.get(0));
			tail.children.add(temp);
		}
	}

	private Node getTail(Node node) {
		if (node.children.size() == 0) {
			return node;
		}
		return getTail(node.children.get(0));
	}

	private void display2(Node node) {
		System.out.println("Hii " + node.data);

		for (Node child : node.children) {
			System.out.println("Going towards " + child.data);
			display2(child);
			System.out.println("Coming back from " + child.data);

		}
		System.out.println("Bye " + node.data);
	}

	public void display2() {
		display2(root);
	}

	private void display2back(Node node) {
		System.out.println("Hii " + node.data);

		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			System.out.println("Going towards " + child.data);
			display2back(child);
			System.out.println("Coming back from " + child.data);

		}
		System.out.println("Bye " + node.data);
	}

	public void display2back() {
		display2back(root);
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {
		System.out.print(node.data + " ");// data printed first -> preorder
		for (Node child : node.children) {// child comes next
			preorder(child);
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {

		for (Node child : node.children) {// child comes first
			postorder(child);
		}

		System.out.print(node.data + " ");// data printed next -> postorder
	}

	public void levelorder() {
		// queue used for level by level, stack used for depth search
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			// remove node
			Node rn = q.remove();

			// print data
			System.out.println(rn.data + " ");

			// child enqueue
			for (Node child : rn.children) {
				q.add(child);
			}
		}
		System.out.println();
	}

	public void levelorderlinewise() {
		// queue used for level by level, stack used for depth search
		Queue<Node> q = new LinkedList<>();// primary
		Queue<Node> h = new LinkedList<>();//helper
		q.add(root);

		while (!q.isEmpty()) {
			// remove node
			Node rn = q.remove();

			// print data
			System.out.print(rn.data + " ");

			// child enqueue
			for (Node child : rn.children) {
				h.add(child);
			}
			if (q.isEmpty()) {
				System.out.println();
				//swap or this
				q = h;
				h = new LinkedList<>();
			}
		}
		System.out.println();
	}

	public void levelorderzigzag_Important() {
		// two stacks used
		Stack<Node> s = new Stack<>();
		Stack<Node> h = new Stack<>();

		int count = 0;
		s.add(root);

		while (!s.isEmpty()) {
			// remove
			Node rn = s.pop();

			// print
			System.out.print(rn.data + " ");

			// child
			if (count % 2 == 0) {// straight order
				for (Node child : rn.children) {
					h.push(child);
				}
			} else {// reverse order
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					h.push(rn.children.get(i));
				}
			}

			// s empty
			if (s.isEmpty()) {
				System.out.println();
				count++;
				s = h;
				h = new Stack<>();
			}
		}
	}

}