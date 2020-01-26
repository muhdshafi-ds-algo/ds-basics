package example.linkedlist.doubly;

public class DoublyLinkedList {
	
	int length;
	Node start, end;
	
	public void insertAtBeginning(int value){
		Node node = new Node(value);
		if(start == null) {
			start = node;
			start.setNext(null);
			start.setPre(null);
			end = start;
			length++;
			return;
		}
		
		start.setPre(node);
		node.setNext(start);
		start = node;
		length++;
	}
	
	
	public void insertAtEnd (int value) {
		Node node = new Node(value);
		if(start == null) {
			start = node;
			start.setNext(null);
			start.setPre(null);
			end = start;
			length++;
			return;
		}
		
		end.setNext(node);
		node.setPre(end);
		end = node;
		length++;
	}
	
	public void insertAtPos(int value, int pos) {
		Node node = new Node(value);
		
		if(pos == 0) {//start==null also covered here
			insertAtBeginning(value);
			return;
		}
		
		if(start == end) {
			insertAtEnd(value);
			return;
		}
		
		int count = 0;
		Node temp = start;
		
		while(temp != end) {
			if(pos == count++) {
				break;
			}
			temp = temp.getNext();
		}
		
		node.setNext(temp);
		node.setPre(temp.getPre());
		temp.getPre().setNext(node);
		temp.setPre(node);
		
	}
	
	public Node removeAtPos( int value, int pos) {
		if(start == null) {
			return null;
		}
		
		if(start == end) {
			Node result = start;
			start = end = null;
			return result;
		}
		
		int count = 0;
		Node temp = start;
		
		while(temp != end) {
			if(pos == count++) {
				break;
			}
			temp = temp.getNext();
		}
		
		if(temp.getNext() == null) {
			return removeFromEnd();
		}
		
		if(temp.getPre() == null) {
			return removeFromBeginning();
		}
		
		temp.getNext().setPre(temp.getPre());
		temp.getPre().setNext(temp.getNext());
		return temp;
	}
	
	
	public Node removeFromBeginning() {
		
		if(start == null) {
			return null;
		}
		
		Node result = start;
		start = start.getNext();
		if(start != null) {
			start.setPre(null);
		}
		return result;
		
	}
	
	
	public Node removeFromEnd() {
		if(start == null) {
			return null;
		}
		
		Node result = end;
		end = end.getPre();
		if(end != null) {
			end.setNext(null);
		}
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node temp = start;
		sb.append("[");
		while(temp != null) {
			sb.append(temp.getData());
			if(temp.getNext() != null) {
				sb.append(",");
			}
			temp = temp.getNext();
			
		}
		sb.append("]");
		return sb.toString();
	}
	
}
