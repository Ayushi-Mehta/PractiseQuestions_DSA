package Lecture28;

public class StudentClient {

	public static void main(String[] args) {
		Student s = new Student();
		s.name = "Amit";
		s.age = 10;
		System.out.println(s);

	}
	/*
	 * every class in JAVA has a parent class called OBJECT CLASS if you dont make a
	 * parent class, by default the class inherits object class even if you dont
	 * write a code in the class, y9ou still get functions to use as the functions
	 * from parent class ie object class is used
	 */

	/*
	 * we can override the actual syso msg in the child class so the function of
	 * child class will be executed rather than that of object class so we can print
	 * out the message we want even in syso
	 */
	
	
}
