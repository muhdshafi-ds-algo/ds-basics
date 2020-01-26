package example.stack.linkedlist;

public class App {

	public static void main(String[] args) throws Exception {
		StackList sl = new StackList();
		sl.push(1);
		sl.push(2);
		sl.push(3);
		sl.pop();
		System.out.println(sl.top());
	}

}


class StackList{
	
	Node top;
	
	public void push(int value) {
		if(top == null) {
			top = new Node(value);
			return;
		}
		
		Node temp = top;
		top = new Node(value);
		top.next = temp;
		
	}
	
	public int pop() throws Exception {
		if(top == null) {
			throw new Exception("Stack empty");
		}
		Node temp = top;
		top = top.next;
		return temp.value;
	}
	
	public int top() throws Exception {
		if(top == null) {
			throw new Exception("Stack empty");
		}
		return top.value;
	}
}


class Node{
	int value;
	Node next;
	
	Node(int value){
		this.value = value;
	}
}