package Lecture26;

public class Student {
	// data members of student class
	String name = "_";
	int age = 50;

	/*
	 * if constructor not made JAVA automatically creates one its called DEFAULT
	 * CONSTRUCTOR
	 */

	// constructor
	public Student() {// NAME SAME AS CLASS IMP!!
		this.name = "XYZ";// default name of every student
		this.age = 25;// default age
	}

	//parametrized constructor
	public Student(String name, int age) {// NAME SAME AS CLASS IMP!!
		this.name = "ABC";// default name of every student
		this.age = 75;// default age
	}

	/*
	 * if you make your own constructor JAVA wont create its default constructor
	 * then its your responsibility to add default constructor also
	 */

	public void introduceYourself() {
		System.out.println(this.name + " is " + this.age + " years old.");
	}

	public void sayHi(String name) {
		System.out.println(name + " says Hi to " + name);
	}

	public void saysHi(String name) {
		int rollNo = 0;// this cant be used here as it is not a data member of the original class
		System.out.println(this.name + " says Hi to " + name);
	}

	public void fun(Student s) {
		s.introduceYourself();
		introduceYourself();
	}

}
