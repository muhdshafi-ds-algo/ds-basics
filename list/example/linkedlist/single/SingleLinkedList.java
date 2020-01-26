package example.linkedlist.single;

public class SingleLinkedList {
	public Node start;
	private int length;


	
	/**
	 * Add at the End
	 * @param value
	 */
	public void addAtEnd(Node node) {
		
		Node temp = start;
		if (temp != null) {
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(node);
		} else {
			this.start = node;
		}
		length++;
	}
	/**
	 * Add at the Beginning
	 */
	public void addAtBeginning(Node node) {
		Node temp = start;
		start = node;
		start.setLink(temp);
		length++;
	}
	
	/**
	 * Insert at given position
	 * 
	 * length is 1 based
	 * position is 0 based
	 * 
	 * @param node
	 * @param position
	 * @throws Exception 
	 */
	public void Add(Node node, int position) throws Exception {
		
		if(position < 0) {
			position = 0;
		}
		
		if(position > length) {
			position = length;
		}
		
		if(start == null) {
			start = node;
			length++;
			return;
		}
		
		if(position == 0) {
			Node temp = start;
			start = node;
			start.setLink(temp);
			length++;
			return;
		}
		
		int count = 0;
		Node pre = start, next = start.getLink();
		
		if(next == null) {
			start.setLink(node);
			length++;
			return;
		}
		
		while(next != null) {
			if(++count == position) {
				break;
			}
			pre = pre.getLink();
			next = next.getLink();
		}
		
		if(next == null) {
			pre.setLink(node);
		}else {
			Node temp = next;
			pre.setLink(node);
			pre.getLink().setLink(temp);
		}
		
		length++;
	}
	
	/**
	 * Remove from beginning
	 */
	public Node removeBeginning() {
		if(start == null) {
			return null;
		}
		
		Node temp = start;
		start = temp.getLink();
		length--;
		return temp;
		
	}
	
	public Node removeEnd() {
		if(start == null) {
			return null;
		}
		
		Node temp = start, next = start.getLink();
		
		if(next == null) {
			start = null;
			length--;
			return temp;
		}
		
		while(next.getLink() != null) {
			next = next.getLink();
			temp = temp.getLink();
		}
		
		temp.setLink(null);
		length--;
		return next;
	}
	
	public Node remove(Node node) {
		if(start == null) {
			return null;
		}
		
		Node pre = start, curr = start.getLink(), next = null;
		while(curr != null) {
			
			if(curr.equals(node)) {
				next = curr.getLink();
				break;
			}
			
			pre = pre.getLink();
			curr = curr.getLink();
		}
		
		pre.setLink(next);
		length--;
		return curr;
	}
	
	
	public Node remove(int position) {
		if(start == null) {
			return null;
		}
		
		if(0 > position ) {
			position = 0;
		}
		
		if(position >= length) {
			position  = length-1;
		}
		
		if(position == 0) {
			Node temp = start;
			start = start.getLink();
			length--;
			return temp;
		}
		int count = 0;
		Node pre = start, curr = start.getLink(), next = null;
		while(curr != null) {
			if(position == ++count) {
				break;
			}
			pre = pre.getLink();
			curr = curr.getLink();
		}
		
		pre.setLink(curr.getLink());
		length--;
		return curr;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		Node temp = start;
		strBuilder.append("[");
		while (temp != null) {
			strBuilder.append(String.valueOf(temp.getValue()));
			temp = temp.getLink();
			if(temp != null) {
				strBuilder.append(", ");
			}
			
		}
		strBuilder.append("]");
		return strBuilder.toString();
	}
	
	public static String print(Node head) {
		StringBuilder strBuilder = new StringBuilder();
		Node temp = head;
		strBuilder.append("[");
		while (temp != null) {
			strBuilder.append(String.valueOf(temp.getValue()));
			temp = temp.getLink();
			if(temp != null) {
				strBuilder.append(", ");
			}
			
		}
		strBuilder.append("]");
		return strBuilder.toString();
	}
	
	public int size() {
		return length;
	}
	
}
