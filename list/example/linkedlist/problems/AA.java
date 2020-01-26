package example.linkedlist.problems;

import java.util.HashMap;
import java.util.Map;

import example.linkedlist.single.Node;
import example.linkedlist.single.SingleLinkedList;

public class AA {
	public static int counterRecursion = 0;
	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.addAtEnd(new Node(1));
		linkedList.addAtEnd(new Node(2));
		linkedList.addAtEnd(new Node(3));
		linkedList.addAtEnd(new Node(4));
		linkedList.addAtEnd(new Node(5));
		
		System.err.println(linkedList);
		
		System.out.println(getNthFromEndOne(linkedList, 3));
		System.out.println(getNthFromEndOne(linkedList, 1));
		System.out.println(getNthFromEndOne(linkedList, 4));
		
		System.out.println(getNthFromEndTwo(linkedList, 3));
		System.out.println(getNthFromEndTwo(linkedList, 1));
		System.out.println(getNthFromEndTwo(linkedList, 4));
		
		System.out.println(getNthFromEndFour(linkedList, 3));
		System.out.println(getNthFromEndFour(linkedList, 1));
		System.out.println(getNthFromEndFour(linkedList, 4));
		
		System.err.println("Middle:"+findMiddleNode(linkedList.start));
		System.out.println("Even or Odd: "+findEvenOrOdd(linkedList.start));
	}

	/**
	 * Approach 1 - O(n2)
	 * 
	 * @return
	 */
	public static Node getNthFromEndOne(SingleLinkedList linkedList, int n) {
		Node temp = linkedList.start;
		for (int i = 0; i < linkedList.size(); i++) {
			int count = 0;
			for (int j = i; j < linkedList.size(); j++) {
				count++;
			}

			if (count < n) {
				return null;
			}
			
			if(count == n) {
				return temp;
			}
			temp = temp.getLink();
		}
		return null;
	}
	
	/**
	 * Store the nodes in a Map  O(n)  O(m)
	 * @param linkedList
	 * @param n
	 * @return
	 */ 
	public static Node getNthFromEndTwo(SingleLinkedList linkedList, int n) {
		Map<Integer, Node> map = new HashMap();
		Node  temp = linkedList.start;
		for(int i=0; i<linkedList.size(); i++) {
			map.put(i+1, temp);
			temp = temp.getLink();
		}
		return map.get(map.size()-(n-1));
	}
	/**
	 * Optimized O(n) O(1)
 	 * @param linkedList
	 * @param n
	 * @return
	 */
	public static Node getNthFromEndFour(SingleLinkedList linkedList, int n) {
		Node temp = linkedList.start;
		Node nth = linkedList.start;
		int count = 0;
		while(temp != null) {
			count++;
			if(count > n) {
				nth = nth.getLink();
			}
			temp = temp.getLink();
		}
		return nth;
	}
	/**
	 * Recursion Time O(2n) = O(n), space O(n) stack
	 * @param head
	 * @param n
	 * @return
	 */
	public static Node getNthFromEndFive(Node head, int n) {
		
		if(head != null) {
			getNthFromEndFive(head.getLink(), n);
			counterRecursion++;
			if(counterRecursion == n) {
				return head;
			}
		}
		
		return null;
		
	}
	/**
	 * Find middle node fast and slow pointers
	 * @param head
	 * @return
	 */
	public static Node findMiddleNode(Node head) {
		
		Node fast = head, slow = head;
		 while(fast != null && fast.getLink() != null && fast.getLink().getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
			
		}
		
		return slow;
		
	}
	
	public static String findEvenOrOdd(Node head) {
		
		Node fast = head;
		while(fast != null && fast.getLink() != null) {
			fast = fast.getLink().getLink();
		}
		
		if(fast == null) {
			return "Even";
		}else {
			return "Odd";
		}
		
	}

}
