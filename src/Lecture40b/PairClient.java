package Lecture40b;

import Lecture40.Car;

public class PairClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pair<String> pair = new Pair<>();
		pair.one = "abc";
		pair.two = "def";

		Pair<Integer> pair1 = new Pair<>();
		pair1.one = 120;
		pair1.two = 20;

		PairTwo<Integer, String> pair2 = new PairTwo<>();
		pair2.one = 10;
		pair2.two = "abc";
		
		LinkedListGeneric<Car> list= new LinkedListGeneric<>();
		Car[] cars = new Car[5];
		cars[0] = new Car(1000, 400, "Red");
		cars[1] = new Car(2000, 200, "Yellow");
		cars[2] = new Car(500, 900, "Black");
		cars[3] = new Car(300, 30, "Grey");
		cars[4] = new Car(700, 60, "White");
		
		list.addLast(cars[0]);
		list.addLast(cars[1]);
		list.addLast(cars[2]);
		list.addLast(cars[3]);
		list.addLast(cars[4]);
		
		list.display();
		
	}

}
