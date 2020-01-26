package example.tree.problems;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import example.tree.demo.TreeNode;

/**
 * 
 * Zig zag traversal
 * 
 * left to right then right to left and so on
 * 
 * 			     1
 * 			   /  \ 
 *           2      3
 *          / \    / \
 *         4   5  6   7
 * 
 * improve the level order traversal in such a way that the alternate level print in reverse order, it can be achieved by using an extra stack
 * 
 * @author king
 *
 */
public class AX {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		zigZag(root);
	}


	public static void zigZag(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean rightToLeft = false;

		while (!q.isEmpty()) {
			int qSize = q.size();
			Stack<TreeNode> s = new Stack<>();
			for (int i = 0; i < qSize; i++) {
				TreeNode visited = q.poll();
				if (rightToLeft) {
					s.push(visited);
				} else {
					System.out.print(visited + " ");
				}

				if (visited.left != null) {
					q.add(visited.left);
				}
				if (visited.right != null) {
					q.add(visited.right);
				}
			}
			if (rightToLeft) {
				while(!s.isEmpty()) {
					System.out.print(s.pop()+" ");
				}
			}
			rightToLeft = !rightToLeft;
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
