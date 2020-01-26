package example.linkedlist.single;


public class Node {
	private int value;
	private Node link;

	public Node() {

	}
	
	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		
		return String.valueOf(value);
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Node) {
			return ((Integer)this.getValue()).equals(((Node) obj).getValue()); 
		}else {
			return false;
		}
		
	}
}
