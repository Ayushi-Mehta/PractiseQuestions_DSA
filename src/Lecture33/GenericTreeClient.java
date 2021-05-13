package Lecture33;

public class GenericTreeClient {

	//input- 10 3 20 2 50 0 60 1 80 0 30 0 40 1 70 0
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericTree gt= new GenericTree();
		//gt.display();
		//System.out.println(gt.size());
		
		//System.out.println(gt.max());
		//System.out.println(gt.find(70));
		//System.out.println(gt.height());
		//gt.mirror();
		//gt.display();
		//gt.printAtLevel(2);
		//System.out.println();
		//gt.linearize();
		//gt.display2();
		//System.out.println("----------");
		//gt.display2back();
		//gt.preorder();
		//System.out.println("----------------");
		//gt.postorder();
		//System.out.println("----------------");
		//gt.levelorder();
		//System.out.println("----------------");
		//gt.levelorderlinewise();
		gt.levelorderzigzag();
	}
}
