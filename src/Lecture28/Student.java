package Lecture28;

public class Student {

	String name;
	int age;

	@Override
	public String toString() {
		return "Hi I am a student. My name is " + name + " and my age is " + age;
	}

	/*
	 * we can override the actual syso msg in the child class so the function of
	 * child class will be executed rather than that of object class so we can print
	 * out the message we want even in syso
	 */
}
