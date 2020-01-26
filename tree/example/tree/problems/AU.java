package example.tree.problems;


import example.tree.demo.TreeNode;
/**
 * 1. DFS
 * 2. recursive
 * @author king
 *
 */
public class AU {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		TreeNode.printLevelOrder(root);
		System.out.println("\nancestors:");
		printAncestors(root, root.right.right);
		
		System.out.println("\nancestors:");
		printAncestors(root, 7);
	}

	
	public static boolean printAncestors(TreeNode root, TreeNode node) {
		if(root == null) {
			return false;
		}
		if(root.left == node || root.right == node 
				|| printAncestors(root.left, node) || printAncestors(root.right, node)) {
			System.out.print(root.value+" ");
			return true;
		}
		return false;
	}

	
	public static boolean printAncestors(TreeNode root, int node) {
		if(root == null) {
			return false;
		}
		
		if(printAncestors(root.left, node) || printAncestors(root.right, node) 
				|| (root.left != null && root.left.value == node)
				|| (root.right != null && root.right.value == node)) {
			if(root.left != null && root.left.value == node) {
				System.out.print(root.left.value+" ");
			}
			if(root.right != null && root.right.value == node) {
				System.out.print(root.right.value+" ");
			}
			System.out.print(root.value+" ");
			return true;
		}
		return false;
	}


	
	
	
	
	
	
	
	
	
	
	
}
