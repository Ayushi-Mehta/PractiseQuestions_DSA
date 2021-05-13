package Lecture28;

public class Client {

	public static void main(String[] args) {
		// Child obj= new Child();
		// obj.fun();
		// C inherits everything P has but not the other way round
		// C becomes dependent on P

		// case1
		// Parent reference
		Parent obj1 = new Parent();
		// parent instance
		System.out.println(obj1.d);// 10
		System.out.println(obj1.d1);// 100
		obj1.fun();// in P fun
		obj1.fun1();// in P fun1

		// case2
		Parent obj2 = new Child();
		// just like List=new ArrayList
		System.out.println(obj2.d);
		/*
		 * whenever there is a conflict of variables, it is resolved on the basis of
		 * reference
		 */
		System.out.println(obj2.d1);
		System.out.println(((Child) obj2).d2);// typecasting into Child class
		// error as compiler considers the left side only

		System.out.println(((Child) obj2).d);// typecasting into Child class
		/*
		 * now here d of child class is accessed
		 */

		/*
		 * all options according to P as things are in the hands of the compiler while
		 * we are writing the code compiler will consider only the left side of the
		 * statement ie Parent obj2
		 * 
		 */

		obj2.fun();// in C's fun !!!
		/*
		 * for functions, flow first goes to the RHS ie the one with the new keyword and
		 * there checks for the function if it is found, that one is executed
		 */

		((Parent) obj2).fun();// INVALID -> OVERRIDING !!! --> VERY VERY VERY IMP!!
		// Child class' function OVERRIDES the Parent class' function
		/*
		 * typecasting here wont matter as the flow will still check RHS and execute
		 * when fun is found
		 */
		/*
		 * this is done as you would only consider making the same function if there are
		 * some changes to make the original one better thus it ALWAYS executes the new
		 * one, here Child class
		 */

		obj2.fun1();// P's fun1
		// obj2.fun2;//obj2 if of P type which fun2 doesnt exist
		((Child) obj2).fun2();// compiler ko chup krwa do
		/*
		 * not overriding here as there is no fun2 in child class now the object is
		 * typecasted and it works normally
		 */

		// case3

//		Child obj3 = new Parent();//NOT ALLOWED!!
		// reference-Child
		// Instance-Parent
		
		//obj3 is assumed to be of C type
		/*
		 * this statement is NEVER allowed in ANY programming language because obj.
		 * would allow to access every function of both Child and Parent 
		 */

//		System.out.println(obj3.d);
//		System.out.println(obj3.d1);
//		System.out.println(obj3.d2);// runtime error
		
		/*
		 * at runtime , only data members of Parent class will be allocated memory
		 * as RHS is  executed at runtime which is Parent
		 * Parent doesn't contain anything from Child
		 * so Child isn't allocated any memory as Parent is not dependent on Child at all!!
		 * thus d2 variable hasnt been allocated any space
		 */
		
		//case 4
		Child obj4=new Child();
		
		System.out.println(obj4.d);
		System.out.println(obj4.d1);
		System.out.println(obj4.d2);
		
		/* 
		 * Child has all prop of Parent
		 * by default, it is based on reference so d is that of child class
		 */
		System.out.println(((Parent)obj4).d);//type casted variable to Parent class
			
	}

}
