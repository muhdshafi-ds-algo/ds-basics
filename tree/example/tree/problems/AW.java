package example.tree.problems;


import example.tree.demo.TreeNode;


public class AW {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println("LCA:"+lcaRec(root, 5, 2));

	}

	public static TreeNode lcaRec(TreeNode node, int a, int b) {
		if(node == null || node.value == a || node.value == b) {
			return node;
		}
		TreeNode left = lcaRec(node.left, a, b);
		TreeNode right = lcaRec(node.right, a, b);
		if(left != null && right != null) {
			return node;
		}
		if(left != null) {
			return left;
		}
		if(right != null) {
			return right;
		}
		return null;
	}
	
	
	
}
