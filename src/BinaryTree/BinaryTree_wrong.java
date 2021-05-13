package BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree_wrong {
	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
//
//		Node(int data, Node right, Node left) {// constructor for Node
//			this.data = data;
//			this.right = right;
//			this.left = left;
//		}
	}

	private Node root = null;
	int size = 0;

	BinaryTree_wrong() {// constructor for BinaryTree
		this.root = takeInput(null, true);
	}

	private Node takeInput(Node parent, boolean isLeftOrRight) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			if (isLeftOrRight) {
				System.out.println("Enter the data of left child of " + parent.data);
			} else {
				System.out.println("Enter the data of right child of " + parent.data);
			}
		}

		int nodeData = scn.nextInt();
		Node node = new Node();
		node.data = nodeData;
		this.size++;

		boolean choice = false;
		System.out.println("Do you have left child of " + node.data);
		choice = scn.nextBoolean();

		if (choice) {
			node.left = takeInput(node, true);
		}

		boolean choice1 = false;
		System.out.println("Do you have right child of " + node.data);
		choice1 = scn.nextBoolean();

		if (choice1) {
			node.left = takeInput(node, false);
		}

		return node;
	}

	public void display() {
		System.out.println("---------------------------");
		this.display(this.root);
		System.out.println("---------------------------");
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left != null) {
			str = str + node.left.data;
		} else {
			str = str + ".";
		}

		str = str + "=>" + node.data + "<=";

		if (node.right != null) {
			str = str + node.right.data;
		} else {
			str = str + ".";
		}

		System.out.println(str);

//		if (node.left != null) {
//			// if this check is not there,
//			// it will give null pointer exception
//			System.out.println("*");
		display(node.left);
//		}
//		if (node.right != null) {
		display(node.right);
//		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		int max = Math.max(lh, rh);

		return max + 1;
	}

	public void preOrder() {
		System.out.println("---------------------------");
		preOrder(root);
		System.out.print("END");
		System.out.println();
		System.out.println("---------------------------");
	}

	private void preOrder(Node node) {// node left right
		if (node == null) {
			return;
		}
		System.out.print(node.data + " , ");

		preOrder(node.left);
		preOrder(node.right);

	}

	public void postOrder() {
		System.out.println("---------------------------");
		postOrder(root);
		System.out.print("END");
		System.out.println();
		System.out.println("---------------------------");
	}

	private void postOrder(Node node) {// left right node
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);

		System.out.print(node.data + " , ");
	}

	public void inOrder() {
		System.out.println("---------------------------");
		inOrder(root);
		System.out.print("END");
		System.out.println();
		System.out.println("---------------------------");
	}

	private void inOrder(Node node) {// left node right
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + " , ");
		inOrder(node.right);

	}

	public void levelOrder() {
		System.out.println("---------------------------");
		levelOrder(root);
		System.out.print("END");
		System.out.println();
		System.out.println("---------------------------");
	}

	private void levelOrder(Node node) {// left node right

		LinkedList<Node> queue = new LinkedList<>();// LL used as Queue
		queue.add(node);
		while (!queue.isEmpty()) {
			Node rv = queue.removeFirst();
			System.out.print(rv.data + ",");
			if (rv.left != null) {
				queue.addLast(rv.left);
			}
			if (rv.right != null) {
				queue.addLast(rv.right);
			}
		}
	}

	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data > max || node.data < min) {
			return false;
		} else if (!isBST(node.left, min, node.data)) {
			return false;
		} else if (!isBST(node.right, node.data, max)) {
			return false;
		}

		return true;
	}
	
	public int diameter() {
		return diameter(root);
	}
	
	private int diameter(Node node) {
		if(node==null) {
			return 0;
		}
		int case1=height(node.left)+height(node.right)+2;
		//when diameter passes through the root
		
		int case2=diameter(node.left);
		
		int case3=diameter(node.right);
		
		int myans=Math.max(case1, Math.max(case2, case3));
		return myans;
	}
	
	public class DiaPair{
		int height;
		int diameter;
		
		DiaPair(){
			
		}
		
		DiaPair(int height,int diameter){
			this.height=height;
			this.diameter=diameter;
		}
	}
	
	public int diameterBetter() {
		return diameterBetter(root).diameter;
	}
	
	public DiaPair diameterBetter(Node node) {
		if(node==null) {
			DiaPair bp=new DiaPair(-1,0);
			return bp;
		}
		DiaPair lp=this.diameterBetter(node.left);
		DiaPair rp=this.diameterBetter(node.right);
		
		DiaPair mp=new DiaPair();
		mp.height=Math.max(lp.height, rp.height)+1;
		mp.diameter=Math.max(lp.height+rp.height+2,Math.max(lp.diameter,rp.diameter));
		
		return mp;
	}
	
	public int sumLeaf() {
		return sumLeaf(root);
	}
	
	private int sumLeaf(Node node) {
		if(node==null) {
			return 0;
		}
		if(node.left==null && node.right==null) {
			return node.data;
		}
		int lsum=sumLeaf(node.left);
		int rsum=sumLeaf(node.right);
		
		return lsum+rsum;
	}
}
