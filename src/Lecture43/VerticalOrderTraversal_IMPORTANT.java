package Lecture43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import Lecture34.BinaryTree;

public class VerticalOrderTraversal_IMPORTANT extends BinaryTree {

	private class VOPair {
		Node node;
		int vl;

		public VOPair(Node node, int vl) {
			this.node = node;
			this.vl = vl;
		}

		@Override
		public String toString() {
			return node.data + " -> " + vl;
		}
	}

	public void verticalOrderTraversal() {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<VOPair> q = new LinkedList<>();

		VOPair sp = new VOPair(root, 0);
		q.add(sp);

		while (!q.isEmpty()) {
			VOPair rp = q.remove();

			if (!map.containsKey(rp.vl))
				map.put(rp.vl, new ArrayList<>());

			map.get(rp.vl).add(rp.node.data);

			if (rp.node.left != null) {
				VOPair lcp = new VOPair(rp.node.left, rp.vl - 1);
				q.add(lcp);
			}

			if (rp.node.right != null) {
				VOPair rcp = new VOPair(rp.node.right, rp.vl + 1);
				q.add(rcp);
			}
		}

		ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
		Collections.sort(keys);

		for (int key : keys)
			System.out.println(key + " -> " + map.get(key));

	}
	/*
	 * TREE TOP VIEW- PRINT ONLY FIRST ELEMENT OF EACH ARRAYLIST
	 * TREE BOTTOM VIEW- PRINT ONLY LAST ELEMENT OF EACH ARRAYLIST
	 * TREE LEFT VIEW-FIND FIRST ELEMENT OF EVERY LEVEL AND PRINT IT
	 * TREE RIGHT VIEW- FIND LAST ELEMENT OF EVERY LEVEL AND PRINT IT
	 */
}
