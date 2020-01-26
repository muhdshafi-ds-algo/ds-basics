package example.linkedlist.problems;

import example.linkedlist.single.Node;
import example.linkedlist.single.SingleLinkedList;

public class AC {

	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.addAtEnd(new Node(1));
		linkedList.addAtEnd(new Node(2));
		linkedList.addAtEnd(new Node(3));
		linkedList.addAtEnd(new Node(4));
		linkedList.addAtEnd(new Node(5));
		System.out.println(linkedList);
		reverseIterative(linkedList);
		System.out.println(linkedList);
		Node reverse = reverseRecursive(linkedList.start, linkedList);
		System.out.println(linkedList);
		
		System.out.println("Print from end : ");
		printFromEnd(linkedList.start);
	}
	/**
	 * Iterative 
	 * @param head
	 * @return
	 */
	public static void reverseIterative(SingleLinkedList linkedList) {
		
		if(linkedList.start == null) {
			return;
		}
		
		Node pre = null, next = linkedList.start, temp = null;
		
		while(next != null) {
			temp = next;
			next = next.getLink();
			temp.setLink(pre);
			pre = temp;
		}
		linkedList.start =  pre;
		
	}
	/**
	 * Recursive
	 * @param head
	 * @return
	 */
	public static Node reverseRecursive(Node head, SingleLinkedList linkedList) {

		if(head == null) {
			return null;
		}
		
		if(head.getLink() == null) {
			linkedList.start = head;
			return head;
		}
		
		Node node = reverseRecursive(head.getLink(), linkedList);
		node.setLink(head);
		head.setLink(null);
		return head;
		
	}
	
	/**
	 * Print from end
	 * @param head
	 */
	public static void printFromEnd(Node head) {
		if(head != null) {
			printFromEnd(head.getLink());
			System.out.print(head.getValue() + " ");
		}
		
	}
}
