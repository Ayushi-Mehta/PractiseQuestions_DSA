package Lecture40d;

import Lecture40c.Heap;

public class KLargestElements {

	public static void main(String[] args) {

		int[] arr= {20,50,30,45,10,5,57,40};
		kLargestElements(arr, 3);
	}

	public static void kLargestElements(int[] arr, int k) {
		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			int weaker = heap.get();

			if (arr[i] > weaker) {
				heap.remove();
				heap.add(arr[i]);
			}
		}

		while(!heap.isEmpty()) {
			System.out.println(heap.remove());
		}
	}

}
