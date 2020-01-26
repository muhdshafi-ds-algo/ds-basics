package tree.training.genric;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BST<E> {

	private int size;
	private Node begin;
	private Node end;
	private Node root;


	public void insert(E value) {
		// If it is the 1st Node
		if (root == null) {
			root = begin = end = new Node(value);
			size = 1;
			return;
		}

		// Find to be Parent node
		Node walker = root, parent = null;
		while (walker != null) {
			parent = walker;
			
			if (castToComparable(value).compareTo(walker.value) < 0) {
				walker = walker.left;
			} else {
				walker = walker.right;
			}
		}

		// create node
		if (castToComparable(value).compareTo(parent.value) < 0) {
			parent.left = new Node(value, parent);
			if (begin == parent) {
				begin = parent.left;
			}
		} else {
			parent.right = new Node(value, parent);
			if (end == parent) {
				end = parent.right;
			}
		}
		size++;
	}

	@SuppressWarnings("unchecked")
	private Comparable<? super E> castToComparable(E value) {
		return (Comparable<? super E>)value;
	}

	public void delete(E value) {
		if (root == null) {
			throw new RuntimeException("Empty Tree");
		}

		Node node = findNode(value);
		if (node == null) {
			throw new RuntimeException("Not found");
		}

		if (size == 1) {
			deleteSingleRootNode();
			return;
		}

		// Intermediate node or Root node
		if (node.left != null && node.right != null) {
			Node leafNode = getLeftMostNode(node.right);
			node.value = leafNode.value;
			if(node.right.left == null) 
				deleteRightLeafNode(leafNode);
			else
				deleteLeftLeafNode(leafNode);
			return;
		}

		// Leaf node
		if (node.left == null && node.right == null) {
			// Left leaf node
			if (node.parent.left == node) {
				deleteLeftLeafNode(node);
			}
			// Right leaf node
			if (node.parent.right == node) {
				deleteRightLeafNode(node);
			}

		}

		// With only Left Sub Tree
		if (node.left != null && node.right == null) {
			deleteNodeWithOnlyLeftSubTree(node);
		}

		// With only Right Sub Tree
		if (node.left == null && node.right != null) {
			deleteNodeWithOnlyRightSubTree(node);
		}

	}

	/**
	 * 
	 * 
	 * Level order traversal to find the node for the given value.
	 * 
	 * @param value
	 * @return null, if not found
	 */
	private Node findNode(E value) {
		Queue<Node> queue = new LinkedList<Node>();

		Node temp = root;
		queue.add(temp);
		while (!queue.isEmpty()) {
			Node visited = queue.poll();
			if (visited.value.equals(value)) {
				return visited;
			}
			if (visited.left != null) {
				queue.add(visited.left);
			}
			if (visited.right != null) {
				queue.add(visited.right);
			}
		}

		return null;

	}

	private void deleteSingleRootNode() {
		root = begin = end = null;
		size = 0;
	}

	private void deleteLeftLeafNode(Node node) {
		if (begin == node) {
			begin = node.parent;
		}
		node.parent.left = null;
		size--;
	}

	private void deleteRightLeafNode(Node node) {
		if (end == node) {
			end = node.parent;
		}
		node.parent.right = null;
		size--;
	}

	private void deleteNodeWithOnlyLeftSubTree(Node node) {
		if (end == node) {
			end = node.left;
		}
		if (node.parent.left == node) {
			node.parent.left = node.left;
		}
		if (node.parent.right == node) {
			node.parent.right = node.left;
		}
		size--;
	}

	private void deleteNodeWithOnlyRightSubTree(Node node) {
		if (begin == node) {
			begin = node.right;
		}
		if (node.parent.left == node) {
			node.parent.left = node.right;
		}
		if (node.parent.right == node) {
			node.parent.right = node.right;
		}
		size--;
	}

	private Node getLeftMostNode(Node node) {
		if (node == null) {
			return null;
		}
		Node walker = node;
		while (walker.left != null) {
			walker = walker.left;
		}
		return walker;
	}

	/**
	 * Find ancestor who is left child of its ancestor
	 * 
	 * @param current
	 * @return
	 */
	private Node getLeftChildAncestor(Node current) {
		Node parent = current.parent;

		while (parent != null && current == parent.right) {
			parent = parent.parent;
			current = parent;
		}

		return parent;

	}

	public Iterator<E> getIterator() {
		return new IteratorImpl();
	}

	public int size() {
		return size;
	}

	public E first() {
		if (begin == null) {
			throw new IllegalStateException();
		}
		return begin.value;
	}

	public E last() {
		if (end == null) {
			throw new IllegalStateException();
		}
		return end.value;
	}

	private class IteratorImpl implements Iterator<E> {

		Node posForward;

		public IteratorImpl() {
			this.posForward = begin;
		}

		@Override
		public E next() {
			Node inorderSuccessor = getInorderSuccessor(posForward);
			if (posForward == null) {
				throw new IllegalStateException();
			}
			E value = posForward.value;
			posForward = inorderSuccessor;
			return value;
		}

		@Override
		public boolean hasNext() {
			return posForward != null;
		}

	}

	private Node getInorderSuccessor(Node current) {

		if (current == null) {
			return null;
		}

		// If node is right most
		if (current == end) {
			return null;
		}

		// If node has right sub tree
		if (current.right != null) {
			return getLeftMostNode(current.right);
		}

		return getLeftChildAncestor(current);

	}

	private class Node {
		E value;
		Node parent;
		Node left;
		Node right;

		Node(E value) {
			this.value = value;
		}

		public Node(E value, Node parent) {
			super();
			this.value = value;
			this.parent = parent;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("{").append(" v:").append(value);
			if (parent == null)
				sb.append(", p:null");
			else
				sb.append(", p:").append(parent.value);

			if (left == null)
				sb.append(", l:null");
			else
				sb.append(", l:").append(left.value);

			if (right == null)
				sb.append(", r:null");
			else
				sb.append(", r:").append(right.value);
			sb.append(" }");
			return sb.toString();
		}

		public String shortView() {
			StringBuilder sb = new StringBuilder();
			sb.append("{").append(value);
			if (parent == null)
				sb.append(", null");
			else
				sb.append(", ").append(parent.value);

			sb.append(" }");
			return sb.toString();
		}
	}

	@Override
	public String toString() {

		List<String> levelOrder = new ArrayList<>();

		Queue<Node> queue = new LinkedList<Node>();
		Node temp = root;
		queue.add(temp);
		while (!queue.isEmpty()) {
			Node visited = queue.poll();
			levelOrder.add(visited.shortView());
			if (visited.left != null) {
				queue.add(visited.left);
			}
			if (visited.right != null) {
				queue.add(visited.right);
			}
		}

		return String.valueOf(levelOrder);
	}

}
