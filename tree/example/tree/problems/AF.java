package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import example.tree.demo.TreeNode;

public class AF {

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

		printLevelOrderInReverse(root);
	}

	public static void printLevelOrderInReverse(TreeNode node) {
		System.out.println("AF.printLevelOrderInReverse()");
		Queue<TreeNode> q = new LinkedList<>();
		Stack<TreeNode> s = new Stack<>();
		TreeNode temp = node;
		while(temp != null) {
			s.push(temp);
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
			temp = q.poll();
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop().value+" ");
		}
	}
}
