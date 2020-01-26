package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import example.tree.demo.TreeNode;

public class AA {

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
		
		System.out.println(getMax(root));
		System.out.println(getMaxNonRec(root));
	}

	public static int getMax(TreeNode node) {
		int maxValue = Integer.MIN_VALUE;
		if(node != null) {
			
			int leftMaxValue = getMax(node.left);
			int rightMaxValue = getMax(node.right);
			
			if(leftMaxValue > rightMaxValue) {
				maxValue = leftMaxValue;
			}else {
				maxValue = rightMaxValue;
			}
			
			if(node.value > maxValue) {
				maxValue = node.value;
			}
		}
		return maxValue;
	}
	
	
	public static int getMaxNonRec(TreeNode node) {
		int maxValue = Integer.MIN_VALUE;
		TreeNode temp = node;
		Queue<TreeNode> q = new LinkedList<>();
		while(temp != null) {
			if(maxValue < temp.value) {
				maxValue = temp.value;
			}
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
			temp = q.poll();
		}
		
		return maxValue;
	}
}
