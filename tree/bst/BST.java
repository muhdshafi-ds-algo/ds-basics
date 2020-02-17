package bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Bianr Search Tree implementation
 * 1. Add
 * 2. Level Order
 * 3. In order 
 * 4. Delete
 * 5. Predecessor
 * 6. Successor 
 * 7. Find
 * 8. FindMin
 * 9. FindMax
 * 
 * 
 * 
 * 
 * 
 *
 * 
 * @author king
 *
 */
public class BST {
	BSTNode root;

	public void  addRec(int value) {
		root =  addRec(root, value);
	}
	/**
	 * Recursive
	 * 
	 * @param value
	 */
	private BSTNode addRec(BSTNode root, int value) {

		if (root == null) {
			root = new BSTNode(value);
		}

		if (value < root.value) {
			root.left =  addRec(root.left, value);
		} else if (value > root.value) {
			root.right =  addRec(root.right, value);
		}

		return root;
	}

	/**
	 * Print the Level Order Traversal
	 */
	public void levelOrder() {
		System.out.println();
		if (root == null) {
			return;
		}
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		q.add(root);

		while (!q.isEmpty()) {
			BSTNode visited = q.poll();
			System.out.print(visited.value + " ");
			if (visited.left != null) {
				q.add(visited.left);
			}
			if (visited.right != null) {
				q.add(visited.right);
			}
		}

	}
	
	public void inorder() {
		System.out.println();
		inorder(root);
	}
	
	private void inorder(BSTNode root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}

	public void find(int value){
		System.out.println(find(root, value));
	
	}
	
	private boolean find(BSTNode root, int value) {
		if(root == null) {
			return false;
		}
		if(value < root.value) {
			return find(root.left, value);
		}else if(value > root.value){
			return find(root.right, value);
					
		}else {
			return true;
		}
	}
	
	public void findMax() {
		if(root == null) {
			System.out.println("Empty");
		}
		System.out.println(findMax(root));
	}
	
	private int findMax(BSTNode root) {
		if(root.right == null) {
			return root.value;
		}
		return findMax(root.right);
	}
	
	public void findMin() {
		if(root == null) {
			System.out.println("Empty");
		}
		System.out.println(findMin(root));
	}
	
	private int findMin(BSTNode root) {
		if(root.left == null) {
			return root.value;
		}
		return findMin(root.left);
	}

	public void delete(int value) {
		delete(root, value);
	}
	
	private BSTNode delete(BSTNode root, int value) {
		if (root == null) 
			return null;
		if(value < root.value) {
			//Node is in the left sub tree
			root.left = delete(root.left, value);
		}else if(value > root.value) {
			//Node is in the left sub tree
			root.right = delete(root.right, value);
		}else {
			//node to be deleted
			//left and/or right is null
			if(root.left == null) 
				return root.right;
			
			if(root.right == null) 
				return root.left;
			
			//copy predecessor value
			root.value = findMax(root.left);
			//delete predecessor
			root.left = delete(root.left, root.value);
		}
		return root;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
