package avl;

import java.util.LinkedList;
import java.util.Queue;

import bst.BSTNode;

/**
 * 
 * 1. add() 2. delete() 3. getHeight()
 * 
 * 
 * @author king
 *
 */
public class AVL {

	AVLNode root;

	private int getHeight(AVLNode node) {
		if (node == null)
			return 0;
		return node.height;
	}

	private int getBalanceFactor(AVLNode node) {
		if (node == null)
			return 0;
		return getHeight(node.left) - getHeight(node.right);
	}

	/**
	 * Rotate the node x New Root node y
	 * 
	 * @param x
	 * @return y
	 */
	private AVLNode rotateRight(AVLNode x) {
		AVLNode y = x.left;
		AVLNode t = y.right;

		y.right = x;
		x.left = t;
		
		x.height = Math.max(getHeight(x.left), getHeight(x.right));
		y.height = Math.max(getHeight(y.left), getHeight(y.right));

		return y;
	}

	private AVLNode rotateLeft(AVLNode x) {
		AVLNode y = x.right;
		AVLNode t = y.left;

		y.left = x;
		x.right = t;

		x.height = Math.max(getHeight(x.left), getHeight(x.right));
		y.height = Math.max(getHeight(y.left), getHeight(y.right));
		
		return y;
	}

	public void add(int value) {
		root = add(root, value);
	}

	private AVLNode add(AVLNode root, int value) {
		// add the node to BST
		if (root == null)
			return new AVLNode(value);
		if (value < root.value)
			root.left = add(root.left, value);
		else if (value > root.value)
			root.right = add(root.right, value);
		else // duplicate
			return root;

		// for AVL
		root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

		int bf = getBalanceFactor(root);
		if (Math.abs(bf) > 1) {
			// balance the tree
			if (bf > 0) {
				// L case
				if (value < root.left.value) {
					// LL case - single right rotation
					return rotateRight(root);
				} else {
					// LR case - double rotation(Left rotate Left Child then Right Rotate Root)
					root.left = rotateLeft(root.left);
					return rotateRight(root);
				}

			} else {
				// R case
				if (value > root.right.value) {
					// RR case - single left rotation
					return rotateLeft(root);
				} else {
					// RL case - double rotation(Right rotate Right Child then Left Rotate Root)
					root.right = rotateRight(root.right);
					return rotateLeft(root);
				}
			}
		}

		return root;

	}

	public void levelOrder() {
		System.out.println();
		int level = 0;
		if (root == null) {
			return;
		}
		Queue<AVLNode> q = new LinkedList<AVLNode>();
		q.add(root);

		while (!q.isEmpty()) {
			System.out.print("level-" + level++ + ":");
			int size = q.size();
			for (int i = 0; i < size; i++) {
				AVLNode visited = q.poll();
				System.out.print(visited.value + " ");
				if (visited.left != null) {
					q.add(visited.left);
				}
				if (visited.right != null) {
					q.add(visited.right);
				}
			}
			System.out.println();
		}

	}
}
