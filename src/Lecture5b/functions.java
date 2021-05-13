package Lecture5b;

public class functions {

	public static void main(String[] args) {
	
		addition();//function calling
		int val=100;
		System.out.println(addition.val);
		
	}
	//function declaration
	public static int addition( int val) {
		int val=10;
		int a=10;
		int b=20;
		int sum=a+b;
		System.out.println(sum);
		val=val+10;
		System.out.println(val);
	}
}
}
