package adapters;

public class SUQ_PushEfficient_Client {

	public static void main(String[] args) throws Exception {
		StackUsingQueues_PushEfficient stack= new StackUsingQueues_PushEfficient();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.peek());
	}

}
