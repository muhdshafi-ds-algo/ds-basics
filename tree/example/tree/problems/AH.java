package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import example.tree.demo.TreeNode;

public class AH {
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
		
		System.out.println("Minimum depth Recursive:"+findMinDepthRecursive(root));
		System.out.println("Minimum depth Recursive:"+findMinDepthRecursiveAlt(root, 0));
		System.out.println("Minimum depth Level-Order:"+findMinDepthLevelOrder(root));
		
		TreeNode.printLevelOrder(root);
	}

	/**
	 * Level order is more efficient
	 * @param root
	 * @return
	 */
	private static int findMinDepthLevelOrder(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<>();
		if (root == null) {
			return 0;
		}
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			level++;
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				TreeNode visited = q.poll();;
				if(visited.left == null && visited.right == null) {
					return level;
				}
				if(visited.left != null) {
					q.add(visited.left);
				}
				if(visited.right != null) {
					q.add(visited.right);
				}
				
			}
		}

		return 0;
	}

	/**
	 * O(n) but always traverse all the node if the min depth is 1
	 * @param node
	 * @return
	 */
	private static int findMinDepthRecursive(TreeNode node) {
		if(node == null) {
			return 0;
		}
		if(node.left == null && node.right == null) {
			return 1;
		}
		if(node.left == null) {
			return findMinDepthRecursive(node.right) + 1;
		}
		if(node.right == null) {
			return findMinDepthRecursive(node.left) + 1;
		}
		return Math.min(findMinDepthRecursive(node.left), findMinDepthRecursive(node.right)) +1;
	}
	
	
	private static int findMinDepthRecursiveAlt(TreeNode node, int level) {
		if(node == null) {
			return level;
		}
		level++;
		return Math.min(findMinDepthRecursiveAlt(node.left, level), findMinDepthRecursiveAlt(node.right, level));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
