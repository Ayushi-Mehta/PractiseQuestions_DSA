package Lecture41;

public class Student {

	String name;
	int rollNo;

	static int totalStudents;

	public Student(String name) {
		totalStudents++;

		this.rollNo = totalStudents;
		this.name = name;
	}

	// Q- can you access non static variables in non static functions? A- YES
	// Q- can you access non static function in  non static functions? A- YES
	// Q can you access static variable in non static functions? A-YES
	// Q- can you call static function in non static function? A- YESS
	public void introduceYourself() {
		System.out.println(name + " is having roll no " + rollNo);
	}

	// Q- can you access non static variables in static functions? A- NO
	// Q- can you access non static function in static functions? A- NO
	// Q can you access static variable in static functions? A-YES
	// Q- can you call static function in static function? A- YESS
	public static void getTotalStudents() {
		// System.out.println(name); -> error
		System.out.println(totalStudents);
		// introduceYourself(); -> error
	}

}
