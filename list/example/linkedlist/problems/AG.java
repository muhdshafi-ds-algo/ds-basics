package example.linkedlist.problems;

import java.util.HashMap;
import java.util.Map;

import example.linkedlist.circular.single.CircularSinglyList;
import example.linkedlist.circular.single.Node;

public class AG {
	/**
	 * Split a Circular linked list into 2 (for Odd number length, first half longer)
	 * @param args
	 */
	public static void main(String[] args) {
		
		CircularSinglyList list = new CircularSinglyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		
		System.out.println("Original: "+CircularSinglyList.print(list.getHead()));
		Map<String, Node> map =  split(list.getHead());
		System.out.println(CircularSinglyList.print(map.get("Head1")));
		System.out.println(CircularSinglyList.print(map.get("Head2")));
	}
	
	public static Map<String, Node> split(Node head) {
		Node slow = head, fast = null, head1, head2;
		Map<String, Node> map = new HashMap<>();
		if(head == null) {
			return map;
		}
		if(head.getNext() == head || head.getNext().getNext() == head) {
			head1 = head; 
			head1.setNext(head1);
			head2 = head.getNext();
			head2.setNext(head2);
			map.put("Head1", head1);
			map.put("Head2", head2);
			return map;
		}
		
		fast = head;
		while(fast.getNext() != head && fast.getNext().getNext() != head) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		head1 = head;
		head2 = slow.getNext();
		slow.setNext(head1);
		if(fast.getNext() == head) {
			fast.setNext(head2);
		}else if(fast.getNext().getNext() == head) {
			fast.getNext().setNext(head2);
		}
		map.put("Head1", head1);
		map.put("Head2", head2);
		System.out.println(slow +", "+ fast);
		return map;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
