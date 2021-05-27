package Lecture44;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	HashMap<Integer, HashMap<Integer, Integer>> map;

	public Graph(int V) {
		map = new HashMap<>();
		for (int i = 1; i <= V; i++) {
			map.put(i, new HashMap<>());
		}

	}

	public void addEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	public boolean containsEdge(int v1, int v2) {

		return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);
	}

	public void removeEdge(int v1, int v2) {
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}

	public int numEdges() {
		int sum = 0;
		for (int key : map.keySet()) {
			sum += map.get(key).size();
		}
		return sum / 2;// IMPORTANT
	}

	public void display() {
		for (int key : map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}
	}

	public boolean hasPath(int src, int dest, HashSet<Integer> visited) {
		// dest=destination
		// mark source as visited
		visited.add(src);

		// if src and dest are equal then you have found a path
		if (src == dest) {
			return true;
		}

		// check if path exists via neighbours
		for (int nbr : map.get(src).keySet()) {
			if (!visited.contains(nbr)) {// visited[nbr]==false
				boolean res = hasPath(nbr, dest, visited);
				if (res) {
					return true;
				}
			}
		}
		return false;
	}

	public void printAllPath(int src, int dest, HashSet<Integer> visited, String str) {// dest=destination
		// mark source as visited
		visited.add(src);

		// if src and dest are equal then you have found a path
		if (src == dest) {
			System.out.println(str);
//			visited.remove(src);
//			return;
		}
//		visited.add(src);

		// check if path exists via neighbours
		for (int nbr : map.get(src).keySet()) {
			if (!visited.contains(nbr)) {// visited[nbr]==false
				printAllPath(nbr, dest, visited, str + nbr);
			}
		}
		// undo
		visited.remove(src);
	}

	// O(V+E)-All after here
	public boolean BFS(int src, int dst) {
		// BREADTH FIRST SEARCH : ALWAYS GUARANTEES SHORTEST PATH
		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);

		while (!q.isEmpty()) {
			// remove
			int rn = q.remove();

			if (visited.contains(rn)) {
				continue;// so that second time if we encounter/ a node is being removed then you can
							// ignore it ie the rest of the while statement wont work for it
			}

			// visited mark
			visited.add(rn);

			// rn=dst
			if (rn == dst) {
				return true;
			}

			// neighbours
			for (int nbr : map.get(rn).keySet()) {
				if (!visited.contains(nbr)) {
					q.add(nbr);
				}
			}
		}
		return false;
	}

	public boolean DFS(int src, int dst) {
		// DEPTH FIRST SEARCH : DOES NOT GUARANTEES SHORTEST PATH !!!

		HashSet<Integer> visited = new HashSet<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		s.push(src);

		while (!s.isEmpty()) {

			// remove
			int rn = s.pop();

			if (visited.contains(rn)) {
				continue;// so that second time if we encounter/ a node is being removed then you can
							// ignore it ie the rest of the while statement wont work for it
			}

			// visited mark
			visited.add(rn);

			// rn=dst
			if (rn == dst) {
				return true;
			}

			// neighbours
			for (int nbr : map.get(rn).keySet()) {
				if (!visited.contains(nbr)) {
					s.push(nbr);
				}
			}
		}
		return false;
	}

	public void BFT() {
		// BREADTH FIRST TRAVERSAL

		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {
			if (visited.contains(src)) {// FOR DISCONNECTED GRAPHS -> FOREST
				continue;
			}
			q.add(src);

			while (!q.isEmpty()) {

				// remove
				int rn = q.remove();

				if (visited.contains(rn)) {
					continue;// so that second time if we encounter/ a node is being removed then you can
							// ignore it ie the rest of the while statement wont work for it
				}

				// visited mark
				visited.add(rn);

				// print
				System.out.print(rn);

				// neighbours
				for (int nbr : map.get(rn).keySet()) {
					if (!visited.contains(nbr)) {
						q.add(nbr);
					}
				}
			}

		}
		System.out.println();
	}

	public void DFT() {
		// Depth FIRST TRAVERSAL

		HashSet<Integer> visited = new HashSet<Integer>();
		Stack<Integer> s = new Stack<Integer>();

		for (int src : map.keySet()) {
			if (visited.contains(src)) {// FOR DISCONNECTED GRAPHS -> FOREST
				continue;
			}
			s.push(src);

			while (!s.isEmpty()) {

				// remove
				int rn = s.pop();

				if (visited.contains(rn)) {
					continue;
					// so that second time if a node is being removed then you can
					// ignore it ie the rest of the while statement wont work for it
				}

				// visited mark
				visited.add(rn);

				// print
				System.out.print(rn);

				// neighbours
				for (int nbr : map.get(rn).keySet()) {
					if (!visited.contains(nbr)) {
						s.push(nbr);
					}
				}
			}

		}
		System.out.println();
	}

	public boolean isCyclic() {
		// Using BFT

		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {
			if (visited.contains(src)) {// FOR DISCONNECTED GRAPHS -> FOREST
				continue;
			}
			q.add(src);

			while (!q.isEmpty()) {

				// remove
				int rn = q.remove();

				if (visited.contains(rn)) {
					return true;
				}

				// visited mark
				visited.add(rn);

				for (int nbr : map.get(rn).keySet()) {
					if (!visited.contains(nbr)) {
						q.add(nbr);
					}
				}
			}

		}
		return false;
	}

	public boolean isConnected() {
		// BREADTH FIRST TRAVERSAL

		int components = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {
			if (visited.contains(src)) {// FOR DISCONNECTED GRAPHS -> FOREST
				continue;
			}
			q.add(src);
			components++;
			while (!q.isEmpty()) {

				// remove
				int rn = q.remove();

				if (visited.contains(rn)) {
					continue;
				}

				// visited mark
				visited.add(rn);

				// neighbours
				for (int nbr : map.get(rn).keySet()) {
					if (!visited.contains(nbr)) {
						q.add(nbr);
					}
				}
			}

		}
		if (components == 1) {
			return true;
		} else {
			return false;
		}
	}

	// EVERY TREE IS A GRAPH BUT EVERY GRAPH IS NOT A TREE
	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

	public ArrayList<ArrayList<Integer>> getConnectedComponents() {
		// BREADTH FIRST TRAVERSAL

		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<ArrayList<Integer>> BL = new ArrayList<ArrayList<Integer>>();
		// BL= biglist

		for (int src : map.keySet()) {
			if (visited.contains(src)) {// FOR DISCONNECTED GRAPHS -> FOREST
				continue;
			}
			ArrayList<Integer> SL = new ArrayList<Integer>();// SL= small list
			BL.add(SL);
			q.add(src);

			while (!q.isEmpty()) {

				// remove
				int rn = q.remove();

				if (visited.contains(rn)) {
					continue;// so that second time if we encounter/ a node is being removed then you can
								// ignore it ie the rest of the while statement wont work for it
				}

				// visited mark
				visited.add(rn);

				// add in your small list
				SL.add(rn);

				// neighbours
				for (int nbr : map.get(rn).keySet()) {
					if (!visited.contains(nbr)) {
						q.add(nbr);

					}
				}
			}

		}
		return BL;
	}

	// kruskalAlgorithm starts here

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

		for (int vertex : map.keySet()) {// O(2E)
			for (int nbr : map.get(vertex).keySet()) {
				EdgePair np = new EdgePair(vertex, nbr, map.get(vertex).get(nbr));
				edges.add(np);
			}
		}
		return edges;
	}

	public void kruskalAlgorithm() {// O(V)+O(2E)+O(ElogE)+O(E)==O(ElogE)-> worst case-> O(ElogV)
		//O(h)=O(log(base2)n)
		
		DisjointSet ds = new DisjointSet();

		// create a new set for all the vertices
		for (int vertex : map.keySet()) {// O(v)
			ds.create(vertex);// O(1)
		}

		// get all edges
		ArrayList<EdgePair> edges = getAllEdges();
		// edges sort on the basis of cost
		Collections.sort(edges);// O(ElogE)

		for (EdgePair e : edges) {// O(2E)

			int re1 = ds.find(e.v1);// O(1)
			int re2 = ds.find(e.v2);

			if (re1 == re2) {// ignore the same pairs
				// do nothing
			} else {
				System.err.println(e);
				ds.union(e.v1, e.v2);// O(1)
			}

		}
	}

	// prims Algorithm starts here
	private class PrimsPair implements Comparable<PrimsPair> {

		int vname;
		int acqvname;
		int cost;

		public PrimsPair(int vname, int acqvname, int cost) {
			this.vname = vname;
			this.acqvname = acqvname;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return vname + " via " + acqvname + " @ " + cost;
		}

		@Override
		public int compareTo(PrimsPair o) {
			// priority queue is by default a min heap so rather than o.cost-this.cost we do
			// this.cost-o.cost
			return this.cost - o.cost;
		}
	}

	public void prims() {// O(ElogV)
		PriorityQueue<PrimsPair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[map.size() + 1];

		// create a starting pair
		PrimsPair sp = new PrimsPair(1, 0, 0);
		// put pair in priority queue
		pq.add(sp);

		// work till pq is not empty
		while (!pq.isEmpty()) {

			// remove the pair with minimum cost
			PrimsPair rp = pq.remove();

			// if your removed vertex is already visited-> ignore vertex
			if (visited[rp.vname]) {
				continue;
			}

			// visited mark
			visited[rp.vname] = true;

			// printing
			if (rp.acqvname != 0) {
				System.out.println(rp);
			}

			// work for nbrs
			for (int nbr : map.get(rp.vname).keySet()) {// O(2E)

				// work only for unvisited nbrs
				if (!visited[nbr]) {

					// make a pair for nbr and put in priotity queue
					PrimsPair np = new PrimsPair(nbr, rp.vname, map.get(rp.vname).get(nbr));
					pq.add(np);// O(logV)
				}
			}
		}
	}

	// Dijkstra Algorithm starts here
	private class DijkstraPair implements Comparable<DijkstraPair> {

		int vname;
		String psf;// path so far
		int csf;// cost so far

		public DijkstraPair(int vname, String acqvname, int cost) {
			this.vname = vname;
			this.psf = acqvname;
			this.csf = cost;
		}

		@Override
		public String toString() {
			return vname + " via " + psf + " @ " + csf;
		}

		@Override
		public int compareTo(DijkstraPair o) {
			return this.csf - o.csf;
		}
	}

	public void dijkstra(int src) {// O(ElogV)
		PriorityQueue<DijkstraPair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[map.size() + 1];

		// create a starting pair
		DijkstraPair sp = new DijkstraPair(src, src + "", 0);
		// put pair in priority queue
		pq.add(sp);

		// work till pq is not empty
		while (!pq.isEmpty()) {

			// remove the pair with minimum cost
			DijkstraPair rp = pq.remove();

			// if your removed vertex is already visited-> ignore vertex
			if (visited[rp.vname]) {
				continue;
			}

			// visited mark
			visited[rp.vname] = true;

			// printing
			System.out.println(rp);

			// work for nbrs
			for (int nbr : map.get(rp.vname).keySet()) {// O(2E)
				// work only for unvisited nbrs
				if (!visited[nbr]) {
					// make a pair for nbr and put in priotity queue
					DijkstraPair np = new DijkstraPair(nbr, rp.psf + nbr, rp.csf + map.get(rp.vname).get(nbr));
					pq.add(np);// O(logV)
				}
			}
		}
	}

}
