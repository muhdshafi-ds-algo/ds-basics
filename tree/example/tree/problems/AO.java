package example.tree.problems;

import example.tree.demo.TreeNode;
/**
 * diameter == number of nodes on the longest path (path may or may not pass through the root node)
 * 
 * max of a) 1 + height of left sub tree + height of right sub tree 
 *        b) diameter of left sub tree
 *        c) diameter of right sub tree
 * 
 * 
 * @author king
 *
 */
public class AO {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println("Diamter: "+findDiameter(root));
		
	}

	private static int findDiameter(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		return  Math.max((1+findHeight(root.left)+findHeight(root.right)), 
					Math.max(findDiameter(root.left), findDiameter(root.right)));

	}

	private static int findHeight(TreeNode root){
		if(root == null) {
			return 0;
		}
		
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		
		if(leftHeight > rightHeight) {
			return leftHeight+1; 
		} else {
			return rightHeight+1;
		}
	
		
	}
	
}
