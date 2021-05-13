package Lecture40;

import java.util.Comparator;

public class demoGenerics {

	public static void main(String[] args) {

//		Integer[] arri = { 10, 20, -3, 40, 50 };
//		display(arri);
//
//		String[] arrs = { "hello", "India", "delhi" };
//		display(arrs);

		Car[] cars = new Car[5];
		// array that contains 5 cars qith everything null ie default value

		cars[0] = new Car(1000, 400, "Red");// new car created with these values
		cars[1] = new Car(2000, 200, "Yellow");
		cars[2] = new Car(500, 900, "Black");
		cars[3] = new Car(300, 30, "Grey");
		cars[4] = new Car(700, 60, "White");

		//display(cars);// displays the addresses of all the cars

		//bubbleSort(cars);
		bubbleSort(cars, new carSpeedComparator());
		display(cars);
		
		bubbleSort(cars, new carPriceComparator());
		display(cars);
		
		bubbleSort(cars, new carColorComparator());
		display(cars);
	}
//	public static void display(Integer[] arr) {
//		for(Integer i:arr) {
//			System.out.println(i+" ");
//		}
//		System.out.println();
//	}
//	public static void display(String[] arr) {
//		for(String i:arr) {
//			System.out.println(i+" ");
//		}
//		System.out.println();
//	}

	public static <T> void display(T[] arr) {// generic -> Template
		for (T i : arr) {
			System.out.println(i + " ");
		}
		System.out.println();
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int j = 0; j < arr.length - 1 - counter; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {// operator undefined
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int j = 0; j < arr.length - 1 - counter; j++) {
				if (comparator.compare(arr[j], arr[j + 1]) > 0) {// operator undefined
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
