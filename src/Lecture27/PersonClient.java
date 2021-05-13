package Lecture27;

public class PersonClient {

	public static void main(String[] args) {// throws Exception {
		// try {//resolve
		System.out.println("Hello Main");
		Person p = new Person();
		// p.age=-10;
		// p.setAge(-10);

		p.fun(-10);
		/*
		 * the moment exception is THROWN the flow comes here and goes to catch block
		 * and the statements below that are not executed
		 */
		/*
		 * the moment exception is RESOLVED and flow comes back here, the nexxt lines
		 * are normally executed
		 */
		// System.out.println(p.age);
		System.out.println(p.getAge());

		System.out.println("Bye Main");
		// }
		// catch (Exception e) {//resolve
		// System.out.println(e.getMessage());//message given by original msg
		// System.out.println("in catch");
		/*
		 * try/catch is better than throws as program doesn't terminate abruptly and the
		 * statements below (in catch) are still executed
		 */
		// System.out.println("later");
		// }
	}

}
