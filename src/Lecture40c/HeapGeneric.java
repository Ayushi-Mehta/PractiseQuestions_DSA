package Lecture40c;

import java.util.ArrayList;

public class HeapGeneric<T extends Comparable<T>> {//comparable sets bounds of the values T can take

	ArrayList<T> data = new ArrayList<>();

	public void add(T item) {
		data.add(item);
		upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {// ci->child index

		int pi = (ci - 1) / 2;// pi->parent index

		if (isLarger(data.get(ci),data.get(pi))>0) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {
		T ith = data.get(i);
		T jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);

	}

	public void display() {
		System.out.println(data);
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public T remove() {
		swap(0, this.data.size() - 1);// swap first and last value in arraylist
		T rv = this.data.remove(this.data.size() - 1);// delete and show last node
		downheapify(0);

		return rv;
	}

	private void downheapify(int pi) {// parent index
		int lci = 2 * pi + 1;// left child index
		int rci = 2 * pi + 2;// right child index

		int mini = pi;

		if (lci < this.data.size() && isLarger(data.get(lci), data.get(mini))>0) {
			mini = lci;
		}
		if (rci < this.data.size() && isLarger(data.get(rci), data.get(mini))>0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
	}
	
	public T get(){
		return this.data.get(0);
	}
	
	//if priority of t>o -> return >0 value
	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}
}
