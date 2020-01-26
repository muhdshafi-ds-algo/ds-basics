package example.linkedlist.circular.single;

import java.util.List;

public class CircularSunglyListDemo {

	public static void main(String[] args) {
		CircularSinglyList list = new CircularSinglyList();
		System.out.println(list);
		
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtBeginning(4);
		list.insertAtBeginning(5);
		System.out.println(list);
		
		System.out.println(list.deleteFromEnd());
		System.out.println(list);
		
	}

}
