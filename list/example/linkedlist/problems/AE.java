package example.linkedlist.problems;

import example.linkedlist.single.Node;
import example.linkedlist.single.SingleLinkedList;

public class AE {
	/**
	 * Merge 2 sorted linked list
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList linkedList1 = new SingleLinkedList();
		linkedList1.addAtEnd(new Node(1));
		linkedList1.addAtEnd(new Node(2));
		linkedList1.addAtEnd(new Node(6));
		linkedList1.addAtEnd(new Node(7));
		linkedList1.addAtEnd(new Node(9));
		
		SingleLinkedList linkedList2 = new SingleLinkedList();
		linkedList2.addAtEnd(new Node(3));
		linkedList2.addAtEnd(new Node(7));
		linkedList2.addAtEnd(new Node(8));
		linkedList2.addAtEnd(new Node(9));
		linkedList2.addAtEnd(new Node(10));
		
		System.out.println(linkedList1);
		System.out.println(linkedList2);
		Node result = mergeLoop(linkedList1.start, linkedList2.start);
		System.out.println(SingleLinkedList.print(result));

		
		SingleLinkedList linkedList3 = new SingleLinkedList();
		linkedList3.addAtEnd(new Node(1));
		linkedList3.addAtEnd(new Node(2));
		linkedList3.addAtEnd(new Node(6));
		linkedList3.addAtEnd(new Node(7));
		linkedList3.addAtEnd(new Node(9));
		
		SingleLinkedList linkedList4 = new SingleLinkedList();
		linkedList4.addAtEnd(new Node(3));
		linkedList4.addAtEnd(new Node(7));
		linkedList4.addAtEnd(new Node(8));
		linkedList4.addAtEnd(new Node(9));
		linkedList4.addAtEnd(new Node(10));
		
		System.out.println(linkedList3);
		System.out.println(linkedList4);
		Node result2 = mergeRecursion(linkedList3.start, linkedList4.start);
		System.out.println(SingleLinkedList.print(result2));

	}
	/**
	 * Loop
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node mergeLoop(Node head1, Node head2) {
		Node head = null;
		Node curr = null;
		
		//initialize Head
		if(head1 != null && head2 != null) {
			if(head1.getValue() < head2.getValue()) {
				head = new Node(head1.getValue());
				curr = head;
				head1 = head1.getLink();
			}else {
				head = new Node(head2.getValue());
				curr = head;
				head2 = head2.getLink();
			}
		}
		//Comparison
		while(head1 != null && head2 != null) {
			if(head1.getValue() < head2.getValue()) {
				curr.setLink(head1);
				head1 = head1.getLink();
			}else {
				curr.setLink(head2);
				head2 = head2.getLink();
			}
			curr = curr.getLink();
		}
		//one of list reached end
		if(head1 != null) {
			curr.setLink(head1);
		}
		if(head2 != null) {
			curr.setLink(head2);
		}
		
		return head;
		
	}
	/**
	 * Recursion
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node mergeRecursion(Node head1, Node head2) {
		Node head = null;
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		
		if(head1.getValue() < head2.getValue()) {
			head = head1;
			head.setLink(mergeRecursion(head1.getLink(), head2));
		}else {
			head = head2;
			head.setLink(mergeRecursion(head1, head2.getLink()));
		}
		
		return head;
		
	}

}
