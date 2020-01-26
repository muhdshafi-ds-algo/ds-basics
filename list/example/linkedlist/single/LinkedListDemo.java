package example.linkedlist.single;

public class LinkedListDemo {

	public static void main(String[] args) throws Exception {
		
		SingleLinkedList list = new SingleLinkedList();
		list.addAtEnd(new Node(1));
		list.addAtEnd(new Node(2));
		list.addAtBeginning(new Node(3));
		list.addAtEnd(new Node(4));
		System.out.println(list);
		
		System.out.println(list.removeBeginning());
		System.out.println(list.removeEnd());
		System.out.println(list);
		
		list.Add(new Node(5), 1);
		System.out.println(list);
		
		list.Add(new Node(6), 0);
		System.out.println(list);
		
		list.remove(new Node(5));
		System.out.println(list);
		
		list.remove(1);
		System.out.println(list);
	}

}
