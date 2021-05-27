package Lecture46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Lecture44.Graph.DisjointSet;
import Lecture44.Graph.EdgePair;

public class kruskalAlgorithm {
	//done in graph in lecture 44

	private class DisjointSet {

		private class Node {
			int data;
			Node parent;
			int rank;
		}

		private HashMap<Integer, Node> mapping = new HashMap<>();

		public void create(int value) {// O(1)
			Node nn = new Node();
			nn.data = value;
			nn.parent = nn;
			nn.rank = 0;

			mapping.put(value, nn);
		}

		public void union(int value1, int value2) {// O(logn)->O(1)

			Node n1 = mapping.get(value1);
			Node n2 = mapping.get(value2);

			Node re1 = find(n1);
			Node re2 = find(n2);

			if (re1.data == re2.data) {// if(re1==re2)
				return;
			} else {
				if (re1.rank == re2.rank) {
					re2.parent = re1;
					re1.rank++;
				} else if (re1.rank > re2.rank) {
					re2.parent = re1;
				} else {
					re1.parent = re2;
				}
			}

		}

		public int find(int value) {// O(logn)->O(1)

			Node n = mapping.get(value);
			return find(n).data;
		}

		private Node find(Node node) {// O(logn)

			if (node.parent == node) {
				return node;
			}
			Node rr = find(node.parent);// recursion result
			node.parent = rr;// path compression statement--O(h)
			return rr;
		}
	}

	private class EdgePair implements Comparable<EdgePair> {
		int v1;
		int v2;
		int cost;

		public EdgePair(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(EdgePair o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return v1 + "-" + v2 + "@" + cost;
		}
	}

	public ArrayList<EdgePair> getAllEdges() {

		ArrayList<EdgePair> edges = new ArrayList<>();

		for (int vertex : map.keySet()) {//O(2E)
			for (int nbr : map.get(vertex).keySet()) {
				EdgePair np = new EdgePair(vertex, nbr, map.get(vertex).get(nbr));
				edges.add(np);
			}
		}
		return edges;
	}

	public void kruskalAlgorithm() {//O(V)+O(2E)+O(ElogE)+O(E)==O(ElogE)-> worst case-> O(ElogV)

		DisjointSet ds = new DisjointSet();

		// create a new set for all the vertices
		for (int vertex : map.keySet()) {//O(v)
			ds.create(vertex);//O(1)
		}

		// get all edges
		ArrayList<EdgePair> edges = getAllEdges();
		// edges sort on the basis of cost
		Collections.sort(edges);//O(ElogE)
		
		
		for(EdgePair e:edges) {//O(2E)
			
			int re1=ds.find(e.v1);//O(1)
			int re2=ds.find(e.v2);
			
			if(re1==re2) {//ignore the same pairs
				//do nothing
			}else {
				System.err.println(e);
				ds.union(e.v1, e.v2);//O(1)
			}
			
			
		}
	}


}
