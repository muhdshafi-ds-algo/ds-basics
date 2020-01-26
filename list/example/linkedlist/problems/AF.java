package example.linkedlist.problems;

import example.linkedlist.single.Node;
import example.linkedlist.single.SingleLinkedList;

public class AF {

	public static void main(String[] args) {
		SingleLinkedList linkedList1 = new SingleLinkedList();
		linkedList1.addAtEnd(new Node(1));
		linkedList1.addAtEnd(new Node(2));
		linkedList1.addAtEnd(new Node(3));
		linkedList1.addAtEnd(new Node(4));
		linkedList1.addAtEnd(new Node(5));
		linkedList1.addAtEnd(new Node(6));
		System.out.println(linkedList1);
		Node result = reversePairRecursive(linkedList1.start);
		System.out.println(SingleLinkedList.print(result));
	}
	
	public static Node reversePairRecursive(Node head) {
		Node temp = null;
		if(head == null ) {
			return null;
		} 
		if(head.getLink() == null) {
			return head;
		}
		//reverse one pair and point to 3rd node
		temp = head.getLink();
		head.setLink(temp.getLink()); 
		temp.setLink(head);
		head = temp;
		
		//set 3rd node
		head.getLink().setLink(reversePairRecursive(head.getLink().getLink())); 
		
		return head;
		
	}

}
