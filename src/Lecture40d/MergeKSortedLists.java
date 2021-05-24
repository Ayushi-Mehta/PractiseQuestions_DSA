package Lecture40d;

import java.util.ArrayList;

import Lecture40c.HeapGeneric;

public class MergeKSortedLists {// O(nlogk)

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		list.add(new ArrayList<Integer>());
		list.add(new ArrayList<Integer>());
		list.add(new ArrayList<Integer>());
		list.add(new ArrayList<Integer>());

		list.get(0).add(10);
		list.get(0).add(20);
		list.get(0).add(30);

		list.get(1).add(15);
		list.get(1).add(35);

		list.get(2).add(5);
		list.get(2).add(7);
		list.get(2).add(12);
		list.get(2).add(25);

		list.get(3).add(17);
		list.get(3).add(22);
		list.get(3).add(40);

		System.out.println(list);

		System.out.println(mergeTwoSortedLists(list));
	}

	public static class Pair implements Comparable<Pair> {
		int no;
		int list;
		int idx;// index

		@Override
		public int compareTo(Pair o) {
			return o.no - this.no;
		}

	}

	public static ArrayList<Integer> mergeTwoSortedLists(ArrayList<ArrayList<Integer>> List) {
		HeapGeneric<Pair> heap = new HeapGeneric<>();

		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 0; i < List.size(); i++) {// all zero indexed values added to heap
			Pair np = new Pair();
			np.no = List.get(i).get(0);
			np.list = i;
			np.idx = 0;

			heap.add(np);
		}
		
		while (!heap.isEmpty()) {
			
			Pair rp = heap.remove();// removed pair
			res.add(rp.no);// no added to final arraylist
			
			rp.idx++;
			if (rp.idx < List.get(rp.list).size()) {
				rp.no = List.get(rp.list).get(rp.idx);
				heap.add(rp);
			}
		}
		return res;
	}
}
