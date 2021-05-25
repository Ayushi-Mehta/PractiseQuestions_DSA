package Lecture34;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Lecture43.BTCreate;
import Lecture43.LevelOrderToBinaryTree_IMPORTANT.Node;

public class BTCreateFromLevelOrder {

	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	private Node root;
	Scanner scn = new Scanner(System.in);

	public void construct() {
		Queue<Node> q = new LinkedList<>();

		root = new Node(scn.nextInt());
		q.add(root);

		while (!q.isEmpty()) {
			Node remove = q.remove();
			int ld = scn.nextInt();// left data
			if (ld != -1) {// left doesnt exist
				Node ln = new Node(ld);
				remove.left = ln;
				q.add(ln);
			}
			int rd = scn.nextInt();//right data
			if (rd != -1) {// right doesnt exist
				Node rn = new Node(rd);
				remove.right = rn;
				q.add(rn);
			}
		}
	}

	public void display() {
		System.out.println("--------------------");
		display(root);
		System.out.println("--------------------");
	}

	private void display(Node node) {
		if (node == null)
			return;

		String str = "";
		if (node.left == null)
			str += ".";
		else
			str += node.left.data;

		str += " -> " + node.data + " <- ";

		if (node.right == null)
			str += ".";
		else
			str += node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		BTCreate bt = new BTCreate();
		bt.construct();
		bt.display();
	}
}
