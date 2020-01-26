package example.stack.array;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		StackArray sa = new StackArray(5);
		try {
			sa.push(1);

			sa.push(2);
	
		//	sa.pop();
	
			System.out.println(sa.top());

	
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


class StackArray{
	int capacity;
	int[] data ;
	int top = -1;
	
	StackArray(int capacity) {
		this.capacity = capacity;
		data = new int[capacity];
	}
	
	void push(int num) throws Exception{
		if(isFull()) {
			throw new Exception("Stack is full");
		}
		data[++top] = num;
	}
	
	
	int pop() throws Exception{
		if(isEmpty())
			throw new Exception("Stack is empty");
		return data[top--];
	}
	
	int top() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is empty");
		return data[top];
	}
	
	boolean isFull() {
		if(top == (capacity-1)) {
			return true;
		}
		return false;
	}
	
	boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
	
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Arrays.stream(data).forEach(num -> sb.append(num).append(", "));
		sb.replace(sb.length()-5, sb.length(), "]");
		return sb.toString();
	}
}