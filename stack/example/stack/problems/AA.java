package example.stack.problems;


import java.util.Stack;

public class AA {

	public static void main(String[] args) {
		
		String input = "a[b]c{d}(e)";	
		System.out.println(checkBalancedParanthesis(input));
		String input2 = "a[b]c{[d)}(e)";	
		System.out.println(checkBalancedParanthesis(input2));
		
	}

	/**
	 * 1. iterate through the chars
	 * 2. check for all the closing symbol one by one and check corresponding opening present in the stack.
	 *     2.1 not found return false
	 *     2.2 found repeat 1-2 till the end of char list
	 * @return 
	 * 
	 */
	 public static boolean checkBalancedParanthesis(final String input){
		Stack<Character> stack = new Stack();

		for(int i= 0; i< input.length(); i++) {
			char kar = input.charAt(i);
			if(kar == '}') {
				if(!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				}else {
					return false;
				}
			}
			
			if(kar == ']') {
				if(!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				}else {
					return false;
				}
			}
			
			if(kar == ')') {
				if(!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				}else {
					return false;
				}
			}
			
			if(kar == '{' || kar == '[' || kar == '(') {
				stack.push(kar);
			}
		}
		
		return true;
	}
	
}
