package example.tree.problems;


import java.util.HashMap;
import java.util.Map;

import example.tree.demo.TreeNode;

    /* 
 	/* We need to check the Horizontal Distances from the root for all nodes
 	 * If two nodes have the same Horizontal Distance (HD), then they are on the same vertical line
 	 * HD for root is 0, a right edge (edge connecting to right subtree) is considered as +1 horizontal distance 
 	 * and a left edge is considered as -1 horizontal distance.
 	 * 
 	 */
	 
public class AY {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		Map<Integer, Integer> vSumMap = new HashMap<>();
		vSum(vSumMap, root, 0);
		vSumMap.forEach((key, value) -> System.out.println(key+" = "+value));
	}

	private static void vSum(Map<Integer, Integer> vSumMap, TreeNode root, int hd) {
		if(root == null) {
			return ;
		}
		if(root.left != null) {
			vSum(vSumMap, root.left, hd-1);
		}
		if(root.right != null) {
			vSum(vSumMap, root.right, hd+1);
		}
		if (vSumMap.containsKey(hd)) {
			vSumMap.put(hd, vSumMap.get(hd) + root.value);
		}else {
			vSumMap.put(hd, root.value);
		}
	}

	
	
	
	
	
	
	
	
	
	
}
