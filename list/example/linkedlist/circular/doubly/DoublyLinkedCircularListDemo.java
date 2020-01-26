package example.linkedlist.circular.doubly;

public class DoublyLinkedCircularListDemo {

	public static void main(String[] args) {
		System.out.println("DoublyLinkedCircularListDemo.main()");
		DoublyLlnkedCircularList list = new DoublyLlnkedCircularList();
		System.out.println(list);
		list.InsertAtBeginning(1);
		list.InsertAtBeginning(2);
		list.InsertAtBeginning(3);
		System.out.println(list);
	}

}
