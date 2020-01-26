package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import example.tree.demo.TreeNode;
/**
 * width == max number of nodes in one level 
 * @author king
 *
 */
public class AQ {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(2);
		root.right = new TreeNode(39);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println("level with max sum: "+levelWithMaxSum(root));
		
	}
	/**
	 * Level order
	 * 
	 * @param root
	 * @return
	 */
	private static int levelWithMaxSum(TreeNode root) {
		if(root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 0, count = 0, maxSum = 0;
		while(!q.isEmpty()) {
			int qSize = q.size(), sum = 0;
			count++;
			for(int i=0; i<qSize; i++) {
				TreeNode visited = q.poll();
				sum += visited .value;
				if(maxSum < sum) {
					maxSum = sum;
					level = count;
				}
				if(visited.left != null) {
					q.add(visited.left);
				}
				if(visited.right != null) {
					q.add(visited.right);
				}
			}
		}
		
		return level;
	}

	
	
	
	
	
	
	
	
	
	
}
