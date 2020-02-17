package bst;

public class BSTTest {

	public static void main(String[] args) {
		//testLevelOrder();
		//testFind();
		//testMaxMin();
		testDelete();
	}
	
	public static void testLevelOrder () {
		System.out.println("BSTTest.testLevelOrder()");
		BST bst = new BST();
		bst.addRec(5);
		bst.addRec(15);
		bst.addRec(8);
		bst.addRec(2);
		bst.addRec(22);
		bst.addRec(11);
		bst.levelOrder();
		bst.inorder();
	}
	
	public static void testFind() {
		System.out.println("BSTTest.testFind()");
		BST bst = new BST();
		bst.addRec(5);
		bst.addRec(15);
		bst.addRec(8);
		bst.addRec(2);
		bst.addRec(22);
		bst.addRec(11);
		bst.find(22);
	}

	public static void testMaxMin() {
		System.out.println("BSTTest.testMaxMin()");
		BST bst = new BST();
		bst.addRec(5);
		bst.addRec(15);
		bst.addRec(8);
		bst.addRec(2);
		bst.addRec(22);
		bst.addRec(11);
	
		bst.findMax();
		bst.findMin();
	}

	public static void testDelete() {
		System.out.println("BSTTest.testDelete()");
		BST bst = new BST();
		bst.addRec(5);
		bst.addRec(15);
		bst.addRec(8);
		bst.addRec(2);
		bst.addRec(22);
		bst.addRec(11);
		bst.addRec(7);
		bst.levelOrder();
		bst.delete(8);
		bst.levelOrder();
	}



}
