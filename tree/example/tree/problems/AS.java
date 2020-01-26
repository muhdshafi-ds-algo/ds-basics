package example.tree.problems;


import example.tree.demo.TreeNode;

/**
 * 				1
 * 		2				3
 * 	4		5		6		7
 * @author king
 *
 */
public class AS {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println("path exists: " + isPathExists(root, 10));

	}

	private static boolean isPathExists(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (sum == root.value && root.left == null && root.right == null) {
			return true;
		}
		return isPathExists(root.left, sum - root.value) 
				|| isPathExists(root.right, sum - root.value);
	}


	




	
	
	
	
	
	
	
	
	
	
	
}
