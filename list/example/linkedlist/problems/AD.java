package example.linkedlist.problems;

import java.util.HashMap;
import java.util.Map;

import example.linkedlist.single.Node;
import example.linkedlist.single.SingleLinkedList;

public class AD {

	/**
	 * 
	 * Find the merging node of 2 linked list
	 * 
	 * 1. compare each node of 1st list with each of 2nd list (O(mn), O(1))
	 * 2. Use HashMap to store values of 1st iteration, then match in 2nd iteration. O(max(m,n)) O(max(m,n))
	 * 3. Use single loop for both the list O(max(m,n)) ,O(1)
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Map<String, String> map = new HashMap<>();
		map.keySet().stream().forEach(x -> System.out.println(x));

		
		SingleLinkedList linkedList1 = new SingleLinkedList();
		linkedList1.addAtEnd(new Node(1));
		linkedList1.addAtEnd(new Node(2));
		Node node3 = new Node(3);
		linkedList1.addAtEnd(node3);
		linkedList1.addAtEnd(new Node(4));
		linkedList1.addAtEnd(new Node(5));
		linkedList1.addAtEnd(new Node(6));
		System.out.println(linkedList1);
		
		SingleLinkedList linkedList2 = new SingleLinkedList();
		linkedList2.addAtEnd(new Node(1));
		linkedList2.addAtEnd(new Node(2));
		linkedList2.addAtEnd(new Node(3));
		Node node4 = new Node(4);
		node4.setLink(node3);
		linkedList2.addAtEnd(node4);
		System.out.println(linkedList2);
		
		System.out.println(getMergingNodeHash(linkedList1, linkedList2));
		System.out.println(getMergingNodeLoop(linkedList1, linkedList2));
		
	}
	
	
	/**
	 * Using HashMap
	 * @param linkedList1
	 * @param linkedList2
	 * @return
	 */
	public static Node getMergingNodeHash(SingleLinkedList linkedList1, SingleLinkedList linkedList2) {
		Node head1 = linkedList1.start;
		Node head2 = linkedList2.start;
		Map<Node , String> map = new HashMap<>();
		while(head1 != null ) {
			map.put(head1, "");//O(1)
			head1 = head1.getLink();
		}
		
		while(head2 != null ) {
			if(map.containsKey(head2)) {//O(1) best ,O(logn) worst
				return head2;
			}
			head2 = head2.getLink();
		}
		
		return null;
		
	}
	
	/**
	 * Using Single Loop
	 * Find difference in length D,
	 * traverse D nodes in longer list
	 * Iterate trough both using single loop
	 * 
	 * @param linkedList1
	 * @param linkedList2
	 * @return
	 */
	public static Node getMergingNodeLoop(SingleLinkedList linkedList1, SingleLinkedList linkedList2) {
		Node head1 = linkedList1.start;
		Node head2 = linkedList2.start;
		int Length1 = 0, Length2=0,  d = 0;
		
		while(head1 != null) {
			Length1++;
			head1 = head1.getLink();
		}
		while(head2 != null) {
			Length2++;
			head2 = head2.getLink();
		}
		
		if(Length2 > Length1) {
			d = Length2 - Length1;
			head2 = linkedList1.start;
			head1 = linkedList2.start;
		}else {
			d= Length1 - Length2;
			head1 = linkedList1.start;
			head2 = linkedList2.start;
		}
		
		for(int i=0; i<d;i++) {
			head1 = head1.getLink();
		}
		
		while(head1 != null && head2 != null){
			if(head1 == head2) {
				return head1;
			}
			head1 = head1.getLink();
			head2 = head2.getLink();
		}
		return null;
		
	}

}
