package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import example.tree.demo.TreeNode;

public class AI {

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
		
		System.out.println("Deepest node:"+findDeepestNode(root));
		
		TreeNode.printLevelOrder(root);

	}

	/**
	 * Level order - last node
	 * @param root
	 * @return
	 */
	private static Integer findDeepestNode(TreeNode root) {

		if (root == null) {
			return null;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode visited = null;
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				visited = q.poll();
				if (visited.left != null) {
					q.add(visited.left);
				}
				if (visited.right != null) {
					q.add(visited.right);
				}
			}
		}

		return visited.value;
	}

}
