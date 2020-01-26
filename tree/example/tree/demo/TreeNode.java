package example.tree.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {

	public int value;
	public TreeNode right;
	public TreeNode left;
	@Override
	public String toString() {
		return String.valueOf(value) ;
	}
	public TreeNode(int value) {
		this.value = value;
	}



	public void inOrder() {
		
		if(left != null) 
			left.inOrder();
		
		System.out.print(value+" ");
		
		if(right != null) 
			right.inOrder();
		
	}

	public void preOrder() {
		
		System.out.print(value+" ");
		
		if(left != null) 
			left.preOrder();

		if(right != null) 
			right.preOrder();
	}

	public void postOrder() {
		
		if(left != null) 
			left.postOrder();

		if(right != null) 
			right.postOrder();
		
		System.out.print(value+" ");
	}

	
	public void inorderNonRec(TreeNode root) {
		System.out.println("TreeNode.inorderNonRec()");
		Stack<TreeNode> s = new Stack<>();
		TreeNode temp = root;
		boolean done = false;
		
		while(!done) {
			if(temp != null) {
				s.push(temp);
				temp = temp.left;
			}else {
				if(s.isEmpty()) {
					done = true;
				}else {
					temp = s.pop();
					System.out.print(temp.value+" ");
					temp = temp.right;
				}
			}
		}
	}
	
	public void preorderNonRec(TreeNode root) {
		System.out.println("TreeNode.preorderNonRec()");
		Stack<TreeNode> s = new Stack<>();
		TreeNode temp = root;
		boolean done = false;
		
		while(!done) {
			if(temp != null) {
				System.out.print(temp.value+" ");
				s.push(temp);
				temp = temp.left;
			}else {
				if(s.isEmpty()) {
					done = true;
				}else {
					temp = s.pop();
					temp = temp.right;
				}
			}
		}
	}
	
	public void postorderNonRec(TreeNode root) {
		System.out.println("TreeNode.postorderNonRec() TODO");
		//TODO complex, 2 traversal involved in post order 
	}
	
	/**
	 * Simple version
	 * visit all the node from left to right level by level
	 */
	public void levelOrder(TreeNode root) {

		System.out.println("Level order");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode temp = root;
		queue.add(temp);
		while(!queue.isEmpty()) {
			TreeNode visited = queue.poll();
			System.out.print(visited.value + " ");
			if(visited.left != null) {
				queue.add(visited.left);
			}
			if(visited.right != null){
				queue.add(visited.right);
			}
		}
	}
	/**
	 * Proper version
	 * @param root
	 */
	public static void printLevelOrder(TreeNode root){
		System.out.println("\nLevel order:");
		Queue<TreeNode> q = new LinkedList<>();
		if(root == null) {
			return;
		}
		q.add(root);
		int level = 0;
		while(!q.isEmpty()) {
			level++;
			System.out.println();
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				TreeNode visited = q.poll();
				System.out.print(visited.value+" ");
				if(visited.left != null)
					q.add(visited.left);
				if(visited.right != null)
					q.add(visited.right);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
