package example.tree.problems;


import example.tree.demo.TreeNode;

/**
 * 				1
 * 		2				3
 * 	4		5		6		7
 * @author king
 *
 */
public class AT {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		TreeNode.printLevelOrder(root);
		TreeNode mirror = createMirror(root);
		TreeNode.printLevelOrder(mirror);
		
		TreeNode rootOriginal = new TreeNode(1);
		rootOriginal.left = new TreeNode(2);
		rootOriginal.right = new TreeNode(3);
		rootOriginal.left.left = new TreeNode(4);
		rootOriginal.left.right = new TreeNode(5);
		rootOriginal.right.left = new TreeNode(6);
		rootOriginal.right.right = new TreeNode(7);
		System.out.println("\n Mirrors:"+checkMirror(rootOriginal, mirror));
		
	}

	private static TreeNode createMirror(TreeNode root) {
		if(root != null) {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			
			createMirror(root.left);
			createMirror(root.right);
		}
		return root;
	}

	private static boolean checkMirror(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null) {
			return true;
		}
		if(node1 == null || node2 == null) {
			return false;
		}
		
		
		return (node1.value == node2.value) 
				&& checkMirror(node1.left, node2.right)
				&& checkMirror(node1.right, node2.left);
	}


	




	
	
	
	
	
	
	
	
	
	
	
}
