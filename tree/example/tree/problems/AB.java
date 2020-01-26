package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import example.tree.demo.TreeNode;

public class AB {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		root.left = left1;
		TreeNode right1 = new TreeNode(3);
		root.right = right1;
		
		TreeNode left11 = new TreeNode(14);
		left1.left = left11;
		TreeNode left12 = new TreeNode(5);
		left1.right = left12;
		
		TreeNode right11 = new TreeNode(16);
		right1.left = right11;
		TreeNode right12 = new TreeNode(7);
		right1.right = right12;
		
		System.out.println(searchInBT(root, 27));
		System.out.println(searchInBT(root, 14));
		
		System.out.println(searchInBTNonRec(root, 27));
		System.out.println(searchInBTNonRec(root, 14));

	}

	private static boolean searchInBTNonRec(TreeNode root, int value) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode temp = root;
		while(temp != null) {
			if(temp.value == value) {
				return true;
			}
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
			temp = q.poll();
		}
		
		return false;
	}

	public static boolean searchInBT(TreeNode node, int value) {
		if(node == null) {
			return false;
		}
		if(node.value == value) {
			return true;
		}
		return searchInBT(node.left, value) || searchInBT(node.left, value); 
	}
}