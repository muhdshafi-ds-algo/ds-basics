package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import example.tree.demo.TreeNode;

public class AJ {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		root.left = l1;
		TreeNode r1 = new TreeNode(3);
		root.right = r1;
		
		TreeNode l1l2 = new TreeNode(4);
		l1.left = l1l2;
		TreeNode l1r2 = new TreeNode(5);
		l1.right = l1r2;
		
		TreeNode.printLevelOrder(root);
		System.out.println("\nDeliting the node:");
		deleteNode(root, 3);
		TreeNode.printLevelOrder(root);
		
	}

	/**
	 * 1. find the node - level order
	 * 2. replace the current node with deepest node
	 * 3. delete the deepest node
	 * 
	 * this approach is to make the tree balanced
	 * @param root
	 */
	private static void deleteNode(TreeNode root, int value) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode matched = null;
		TreeNode visited = null;
		q.add(root);
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				
				visited = q.poll();
				if (visited.value == value) {
					// found
					matched = visited;
				}
				
				if (visited.left != null) {
					q.add(visited.left);
				}
				if (visited.right != null) {
					q.add(visited.right);
				}
			}
		}
		if(matched != null) {
			matched.value = visited.value;
			//TODO:find parent and delete
		}
		
	}

}
