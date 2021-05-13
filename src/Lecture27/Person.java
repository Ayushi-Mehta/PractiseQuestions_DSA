package Lecture27;

public class Person {

	private String name;

	public int getAge() {// GETTER
		return age;
	}

	public void fun(int age) throws Exception {
		try {
			System.out.println("hello fun");
			setAge(age);
			System.out.println("bye fun");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("in fun catch");
		}
	}

	public void setAge(int age) throws Exception {// SETTER
		// try {
		if (age < 0) {
			// GENERATING A NEW EXCEPTION!
			System.out.println("Hello setAge");
			throw new Exception("Age cannot be negative");
		}
		this.age = age;
		System.out.println("Bye setAge");

		// catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.out.println("in set catch");
		// }
	}

	private int age;
	/*
	 * private values can be indirectly used using GETTERS and Setters
	 */
}
