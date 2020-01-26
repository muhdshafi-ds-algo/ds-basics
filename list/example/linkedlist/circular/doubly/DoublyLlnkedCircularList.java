package example.linkedlist.circular.doubly;

public class DoublyLlnkedCircularList {

	int length;
	Node head, tail;
	
	public void InsertAtBeginning(int data) {
		Node node  = new Node(data);
		if(head == null) {
			head = node;
			length++;
			head.setNext(head);
			head.setPre(head);
			tail = head;
			return;
		}
		
		if(head == tail) {
			length++;
			tail = node;
			head.setNext(tail);
			tail.setNext(head);
			head.setPre(tail);
			tail.setPre(head);
			return;
		}
		
		node.setNext(head);
		node.setPre(tail);
		head.setPre(node);
		tail.setNext(node);
		head = node;
		length++;
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		
		Node curr = head;
		for(int i=0; i<length; i++) {
			sb.append("{")
			.append(curr.getPre()).append("<-").append(curr.getData()).append("->").append(curr.getNext())
			.append("}");
			curr = curr.getNext();
			if(curr != tail) {
				sb.append(",");
			}
		}
		
		sb.append("]");
		return sb.toString();
	}
}
