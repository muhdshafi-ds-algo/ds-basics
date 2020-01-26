package example.linkedlist.circular.single;

public class CircularSinglyList {

	private Node head;
	private int length;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(head == null) {
			return "[]";
		}
		
		sb.append("[");
		Node temp = head;
		sb.append("{"+temp.getData()+"->"+temp.getNext().getData()+"}");
		while(head != temp.getNext()) {
			sb.append(",");
			temp = temp.getNext();
			sb.append("{"+temp.getData()+"->"+temp.getNext().getData()+"}");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public void insertAtEnd(int data){
		if(head == null) {
			head = new Node(data);
			head.setNext(head);
			return;
		}
		
		Node temp = head;
		while(head != temp.getNext()) {
			temp = temp.getNext();
		}
		
		Node node = new Node(data);
		node.setNext(head);
		temp.setNext(node);
		
	}
	
	public void insertAtBeginning(int data) {
		if(head == null) {
			head = new Node(data);
			head.setNext(head);
			return;
		}
		Node temp = head;
		while(head != temp.getNext()) {
			temp = temp.getNext();
		}
		
		Node node = new Node(data);
		node.setNext(head);
		temp.setNext(node);
		head = node;
		
	}
	
	Node deleteFromEnd(){
		if(head == null) {
			return null;
		}
		
		if(head == head.getNext()) {
			Node result = head;
			head = null;
			return result;
		}
		
		Node curr = head.getNext(), result = null, pre = head ;
		while(head != curr.getNext()) {
			curr = curr.getNext();
			pre = pre.getNext();
		}
		
		result = curr;
		pre.setNext(head);
		return result;
	}
	
	Node deleteFromBeginning() {
		if(head == null) {
			return null;
		}
		if(head == head.getNext()) {
			Node result = head;
			head = null;
			return result;
		}
		
		Node last = head;
		while(head == last.getNext()) {
			last = last.getNext();
		}
		
		last.setNext(head.getNext());
		Node result = head;
		head = head.getNext();
		return result;
	}
	
	public static String print (Node node) {
		StringBuilder sb = new StringBuilder();
		if(node == null) {
			return "[]";
		}
		
		sb.append("[");
		Node temp = node;
		sb.append("{"+temp.getData()+"->"+temp.getNext().getData()+"}");
		while(node != temp.getNext()) {
			sb.append(",");
			temp = temp.getNext();
			sb.append("{"+temp.getData()+"->"+temp.getNext().getData()+"}");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
