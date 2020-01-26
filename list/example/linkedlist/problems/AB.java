package example.linkedlist.problems;

import example.linkedlist.single.Node;
import example.linkedlist.single.SingleLinkedList;

public class AB {

	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		list1.addAtEnd(new Node(1));
		Node node1 = new Node(2);
		list1.addAtEnd(node1);
		list1.addAtEnd(new Node(3));
		list1.addAtEnd(new Node(4));
		Node node2 = new Node(5);
		node2.setLink(node1); //cycle
		list1.addAtEnd(node2);
		
		System.out.println("has cycle : "+checkCycle(list1.start));
		System.out.println("start : "+findStartNodeOfCycle(list1.start));
		System.out.println("Length : "+findCycleLength(list1.start));
		removeCycle(list1.start);
		System.out.println("has cycle : "+checkCycle(list1.start));
	}
	/**
	 * Check for cycle
	 * @param head
	 * @return
	 */
	public static boolean checkCycle(Node head) {
		
		Node slow = head, fast = head;
		
		while(slow != null && fast.getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
			if(fast == slow) {
				return true;
			}
		}
		
		return false;
		
	}
	
	/**
	 * Find the start node of Cycle
	 * @param head
	 * @return
	 */
	public static Node findStartNodeOfCycle(Node head){
		
		Node slow = head, fast = head;
		
		while(slow != null && fast.getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
			if(fast == slow) {
				break;
			}
		}
		
		slow = head;
		while(slow != null && fast != null) {
			slow = slow.getLink();
			fast = fast.getLink();
			if(fast == slow) {
				return fast;
			}
		}
		
		return null;
		
	}
	/**
	 * Find the length of the cycle
	 * @param head
	 * @return
	 */
	public static int findCycleLength(Node head) {
		
		Node slow = head, fast = head;
		
		while(slow != null && fast.getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
			if(fast == slow) {
				break;
			}
		}
		
		int count = 0;
		while(fast != null) {
			count++;
			fast = fast.getLink();
			if(fast == slow) {
				break;
			}
		}
		
		return count;
		
	}
	
	/**
	 * Remove cycle from a linkedlist
	 */
	public static void removeCycle(Node head) {
		
		Node fast = head, slow = head;
		while(slow != null && fast.getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
			if(slow == fast) {
				break;
			}
		}
		
		Node pre = slow; //Previous node
		slow = head.getLink();//First node
		fast = fast.getLink();
		while(slow != null && fast != null) {
			if(fast == slow) {
				break;
			}
			pre = pre.getLink();
			fast = fast.getLink();
			slow = slow.getLink();
		}
		
		pre.setLink(null);
		
	}

}
