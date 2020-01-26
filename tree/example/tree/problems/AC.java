package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import example.tree.demo.TreeNode;

public class AC {

	private static boolean inserted = false;
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
		
		insertNodeNonRec(root, 8);
		levelOrderPrint(root);
		System.out.println();
		insertNodeNonRec(root, 9);
		levelOrderPrint(root);
		System.out.println("\n");
		insertNodeRec(root, 10);
		levelOrderPrint(root);
		System.out.println();inserted= false;
		insertNodeRec(root, 11);
		levelOrderPrint(root);
		TreeNode.printLevelOrder(root);
	}


	public static void insertNodeRec(TreeNode root, int value) {
		if(!inserted) {//to avoid inserting again and again
			if(root.left == null) {
				root.left = new TreeNode(value);
				inserted = true;
				return;
			}
			if(root.right == null) {
				root.right = new TreeNode(value);
				inserted = true;
				return;
			}
			insertNodeRec(root.right, value);
			insertNodeRec(root.left, value);
		}
	}
	
	public static void insertNodeNonRec(TreeNode root, int value) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode temp = root;
		queue.add(temp);
		
		while(temp != null) {
			if(temp.left == null) {
				temp.left = new TreeNode(value);
				return;
			}else {
				queue.add(temp.left);
			}
			
			if(temp.right == null) {
				temp.right = new TreeNode(value);
				return;
			}else {
				queue.add(temp.right);
			}
			
			temp = queue.poll();
		}
	}
	
	public static void levelOrderPrint(TreeNode root) {
		System.out.println("Level order");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode temp = root;
		queue.add(temp);
		while(!queue.isEmpty()) {
			TreeNode visited = queue.poll();
			System.out.print(visited.value + " ");
			if(visited.left != null) {
				queue.add(visited.left);
			}
			if(visited.right != null){
				queue.add(visited.right);
			}
		}
	}
	
}
