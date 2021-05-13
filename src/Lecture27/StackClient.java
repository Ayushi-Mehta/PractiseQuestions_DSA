package Lecture27;

public class StackClient {

	public static void main(String[] args) throws Exception {
		Stack s = new Stack(4);

		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		
		//s.data=new int[3];//-> stack got empty as data started pointing to this new empty array
		// such flexibility should not be given to client
		s.display();
		System.out.println(s.pop());
		s.display();
		System.out.println(s.pop());
		s.display();
		System.out.println(s.pop());
		s.display();
		System.out.println(s.pop());
		s.display();
		System.out.println(s.pop());
		s.display();
		
		
	}

}
