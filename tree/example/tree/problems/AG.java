package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import example.tree.demo.TreeNode;

public class AG {

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

		
		System.out.println("Recursive: "+ findHeightRec(root));
		System.out.println("Recursive: "+ findHeightRec(root.right));
		System.out.println("Using Queue: "+ findHeightQueue(root));
		System.out.println("Using Queue: "+ findHeightQueue(root.left));
		
		TreeNode.printLevelOrder(root);
	}

	public static int findHeightRec(TreeNode node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftHeight = findHeightRec(node.left);
		int rightHeight = findHeightRec(node.right);
		
		if ( leftHeight > rightHeight) 
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}
	
	/**
	 * Using Stack
	 * TODO
	 * 
	 * @return
	 */
	public static int findHeightStack(TreeNode node) {
		int height= 0;
		Stack<TreeNode> s = new Stack<>();
		s.push(node);
		TreeNode pre = null;
		while(!s.isEmpty()) {
			TreeNode curr = s.peek();
			if( pre == null || pre.left == curr || pre.right == curr ) {
				//go in depth, it either root or parent and child
				if(curr.left != null) {
					s.push(curr.left);
				}
				if(curr.right != null) {
					s.push(curr.right);
				}
			}else {
				//not under same parent
				
				
			}
			if(s.size() > height) {
				height = s.size();
			}
			
			
			
			
		}
		return height;
		
		
		
		
	}
	
	
	/**
	 * modified level order traversal
	 * @param node
	 * @return
	 */
	public static int findHeightQueue(TreeNode node) {
		int height = 0;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(node);
		
		while(!q.isEmpty()) {
			height++;
			int qSize = q.size(); 
			for(int i =qSize; i>0; i--) {
				TreeNode visited = q.poll();
				if(visited.left != null) {
					q.add(visited.left);
				}
				if(visited.right != null) {
					q.add(visited.right);
				}
			}
			
		}
		
		return height;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
