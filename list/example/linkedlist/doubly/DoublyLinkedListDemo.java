package example.linkedlist.doubly;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {

		DoublyLinkedList list = new DoublyLinkedList();
		System.out.println(list);
		
		list.insertAtBeginning(1);
		list.insertAtBeginning(2);
		list.insertAtBeginning(3);
		System.out.println(list);
		
		list.insertAtEnd(4);
		System.out.println(list);
		
		list.removeFromBeginning();
		System.out.println(list);
		
		list.removeFromEnd();
		System.out.println(list);
		
		list.insertAtPos(5, 1);
		list.insertAtPos(6, 0);
		list.removeFromEnd();
		list.removeFromEnd();
		list.removeFromEnd();
		list.insertAtPos(7, 0);
		System.out.println(list);
		
		list.insertAtBeginning(8);
		System.out.println(list);
		
		list.removeAtPos(1, 1);
		System.out.println(list);
		
		list.removeAtPos(1, 0);
		System.out.println(list);
		
	}

}
