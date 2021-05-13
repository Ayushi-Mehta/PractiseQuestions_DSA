package BinaryTree;

public class BinaryTreeClient {

	public static void main(String[] args) {
		
		// 50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
		
		BinaryTree_wrong tree=new BinaryTree_wrong();
		//constructor se hi call hoga function to create the tree
		tree.display();
		System.out.println(tree.height());
		tree.preOrder();
		tree.postOrder();
		tree.inOrder();
		tree.levelOrder();
		System.out.println(tree.isBST());
		System.out.println(tree.diameter());
		System.out.println(tree.diameterBetter());
		System.out.println(tree.sumLeaf());
	}

}
