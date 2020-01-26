package example.tree.demo;

/**
 * Binary tree - at most 2 children
 * Strict/proper - 0 or 2 
 * complete -   all levels except last one are complete and nodes are as left as possible
 * perfect  - all levels filled
 * balanced b tree - difference between height left and right child should  not be more than K (mostly K=1)
 * 
 * 
 * Implementations
 *   1. Dynamically created Nodes
 *   2. Arrays
 * 
 * @author king
 *
 */
public class TreeDemo{

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		root.left = left1;
		TreeNode right1 = new TreeNode(3);
		root.right = right1;
		
		TreeNode left11 = new TreeNode(4);
		left1.left = left11;
		TreeNode left12 = new TreeNode(5);
		left1.right = left12;
		
		TreeNode right11 = new TreeNode(6);
		right1.left = right11;
		TreeNode right12 = new TreeNode(7);
		right1.right = right12;
		System.out.println("\nInorder");
		root.inOrder();
		System.out.println("\nPreorder");
		root.preOrder();
		System.out.println("\nPostorder");
		root.postOrder();
		System.out.println();
		root.inorderNonRec(root);
		System.out.println();
		root.preorderNonRec(root);
		System.out.println();
		root.postorderNonRec(root);
		root.levelOrder(root);
	}
	

}


