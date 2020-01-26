package example.linkedlist.problems;

import java.util.*;
import java.util.Stack;

public class AH {

	/**
	 * Check palindrome or not?
	 * 1. using stack
	 * 2. reverse half and reconstruct list
	 * 3.recursion
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<> ();
		for (int i=0;i<10;i++) {
		  map.put (i, Integer.toString (i));
		}
		for (Integer key : map.keySet ()) {
		  System.out.println (key);
		}
	}
	
	

}
