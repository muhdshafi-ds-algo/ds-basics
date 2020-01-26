package example.tree.problems;


import example.tree.demo.TreeNode;

    /* 
 	/*
	 * Traverse root to leaf
	 * store values in an array/list
	 * print them all when reach each leaf
	 */
public class AR {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(2);
		root.right = new TreeNode(39);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		printAllRootToLeaf(root);
		
	}


	private static void printAllRootToLeaf(TreeNode root) {
		int[] path = new int[1000];
		printRecursive(root, path, 0);
		
	}
	
	private static void printRecursive(TreeNode node, int[] path, int length) {
		if(node == null) {
			return;
		}
		path[length] = node.value;
		length++;
		if(node.left == null && node.right == null) {
			printPath(path, length);
		}else {
			printRecursive(node.left, path, length);
			printRecursive(node.right, path, length);
		}

	}


	private static void printPath(int[] path, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(path[i]);
			if(i != length-1)
				System.out.print("->");
		}
		System.out.println();
	}

	
	
	
	
	
	
	
	
	
	
	
}
