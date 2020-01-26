package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import example.tree.demo.TreeNode;
/**
 * width == max number of nodes in one level 
 * @author king
 *
 */
public class AP {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println("Width: "+findWidth(root));
		
	}
	/**
	 * Level order
	 * 
	 * @param root
	 * @return
	 */
	private static int findWidth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int width = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			if(width < qSize) {
				width = qSize;
			}
			for(int i=0; i<qSize; i++) {
				TreeNode visited = q.poll();
				if(visited.left != null) {
					q.add(visited.left);
				}
				if(visited.right != null) {
					q.add(visited.right);
				}
			}
		}
		
		return width;
	}

	
	
	
	
	
	
	
	
	
	
}
