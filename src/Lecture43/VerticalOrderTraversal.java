package Lecture43;

import java.util.LinkedList;
import java.util.Queue;

import Lecture34.BinaryTree;

public class VerticalOrderTraversal extends BinaryTree {

	private class VOPair {
		int vl;
		Node node;

		public VOPair(Node node, int vl) {
			this.node = node;
			this.vl = vl;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return node.data + " -> " + VOPair.vl;
	}

	public void voTraversal() {
		Queue<VOPair> q = new LinkedList<>();

		VOPair sp = new VOPair(root, 0);
		q.add(sp);

		while (!q.isEmpty()) {
			VOPair rp = q.remove();

			System.out.println(rp);
			
			if(rp.node.left != null) {
				VOPair lcp= new VOPair(rp.node.left,rp.vl-1);
				q.add(lcp);
				
			}
			if(rp.node.right != null) {
				VOPair rcp= new VOPair(rp.node.right,rp.vl+1);
				q.add(rcp);
				
			}
		}
	}
}
