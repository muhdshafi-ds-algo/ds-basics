package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import example.tree.demo.TreeNode;

public class AL {

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
		System.out.println("\nNumber of full nodes non recursive: "+findNoOfFullNodesNonRec(root));
		System.out.println("\nNumber of full node  recursive: "+findNoOfFullNodesRec(root));
	}
	/**
	 * 
	 * @param root
	 * @return
	 */
	private static int findNoOfFullNodesRec(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left != null && root.right != null) {
			return 1 + findNoOfFullNodesRec(root.left)+findNoOfFullNodesRec(root.right);
		}

		return findNoOfFullNodesRec(root.left)+findNoOfFullNodesRec(root.right);

	}

	/**
	 * 
	 * level order - increment the count when find leaf node
	 * 
	 * @param root
	 * @return
	 */
	private static int findNoOfFullNodesNonRec(TreeNode root) {
		int count = 0;
		if (root == null) {
			return count;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				TreeNode visited = q.poll();
				if(visited.left != null && visited.right != null) {
					count++;
				}
				if(visited.left != null) {
					q.add(visited.left);
				}
				if(visited.right != null) {
					q.add(visited.right);
				}
			}
		}

		return count;
	}

}
