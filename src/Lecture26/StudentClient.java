package Lecture26;

public class StudentClient {

	public static void main(String[] args) {

		
		
		Student s = new Student();
		/* before main is executed it is 
		 * checked which other classes is the main function dependent on
		 */

		/*
		 * student class ka blueprint is saved in heap memory before the main is
		 * executed
		 */

		/*
		 * all data members of new class get memory allocated in heap default values
		 * String->null 
		 * int->0 
		 * address of this entire class is returned to stack left
		 * hand side of stack s here is simply a variable variable in stack memory in
		 * main function frames
		 */

		/*
		 * spaces allocated is called INSTANCE s is called REFERENCE as it is reference
		 * to what is kept in heap memory
		 */

		/* OBJECT can be both INSTANCE or REFERENCE
		 *  TYPICALLY OBJECT REFERS TO INSTANCE!
		 */

		System.out.println(s.name);
		System.out.println(s.age);

		s.name = "Aman";
		s.age = 20;

		System.out.println(s.name);
		System.out.println(s.age);

		Student s1 = s;
		/* NO NEW INSTANCE CREATED JUST NEW 
		 * REFERENCE CREATED TO THE SAME s
		 */

		s1.age = 15;// PERSISTENT CHANGES MADE IN HEAP MEMORY
		System.out.println(s1.name);
		System.out.println(s1.age);

		System.out.println(s.name);
		System.out.println(s.age);

		Student s2 = new Student();

		s2.name = "Rohit";
		s2.age = 30;

		System.out.println(s2.name);
		System.out.println(s2.age);

		s = s2;
		/* s2 values copied in s
		 * BOTH SIDES NEED TO BE COMPATIBLE 
		 * ie BE OF THE SAME CLASS
		 */

		System.out.println(s.name);
		System.out.println(s.age);

		//
		Student s3 = new Student();
		s3.age = 10;
		s3.name = "A";

		Student s4 = new Student();
		s4.age = 20;
		s4.name = "B";

		// Test1(s3, s4);

		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);

		// Test2(s3, s4);

		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);

		// Test3(s3, s4);

		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);

		// Test4(s3, s4);

		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);

		int myAge = 30;
		String myName = "C";
		// Test5(s3, s4.age,s4.name, myAge, myName);

		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);
		System.out.println(myAge + " " + myName);

		s3.introduceYourself();
		s4.introduceYourself();

		s3.sayHi("Amit");
		/* this keyword not used to specify that which 
		 * name is from the class and which name is a variable
		 */

		s3.saysHi("Amit");
		/*
		 * here this keyword is used so the program knows LOCAL>GLOBAL so name means "A"
		 * this.name means "Amit" the program knows which name to use where
		 */

		/*
		 * any class ka function is called in context of a variable "this" is an extra
		 * parameter which is automatically passed when the function is called it
		 * contains the value of the variable called this always points towards the
		 * current object
		 */
		s3.fun(s4);
		
		
		Student s10 = new Student("Ajay", 100);//bracket signifies constructor
		// 1)memory allocate
		// 2)parsing
		// 3)constructor calling
		s10.introduceYourself();
		
	}

	public static void Test1(Student s1, Student s2) {
		Student temp = s1;
		s1 = s2;
		s2 = temp;
	}

	public static void Test2(Student s1, Student s2) {
		int tempa = s1.age;
		s1.age = s2.age;
		s2.age = tempa;

		String tempn = s1.name;
		s1.name = s2.name;
		s2.name = tempn;
		// changes made in heap memory, thus are persistent
	}

	public static void Test3(Student s1, Student s2) {
		s1 = new Student();
		int tempa = s1.age;
		s1.age = s2.age;
		s2.age = tempa;

		String tempn = s1.name;
		s1.name = s2.name;
		s2.name = tempn;
		// changes made in heap memory, thus are persistent
	}

	public static void Test4(Student s1, Student s2) {
		s1 = new Student();
		int tempa = s1.age;
		s1.age = s2.age;
		s2.age = tempa;

		s2 = new Student();
		String tempn = s1.name;
		s1.name = s2.name;
		s2.name = tempn;
		// changes made in heap memory, thus are persistent
	}

	public static void Test5(Student s, int age, String name, int myAge, String myName) {
		s.age = 0;
		s.name = "_";
		age = 0;
		name = "_";
		myAge = 0;
		myName = "_";

	}

}
