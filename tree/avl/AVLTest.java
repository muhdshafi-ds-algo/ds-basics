package avl;

public class AVLTest {

	private static AVL createLL() {
		AVL avl = new AVL();
		avl.add(50);
		avl.add(30);
		avl.add(70);
		avl.add(20);
		avl.add(35);
		avl.add(15);
		avl.add(25);
		return avl;
	}
	
	private static AVL createRR() {
		AVL avl = new AVL();
		avl.add(50);
		avl.add(30);
		avl.add(70);
		avl.add(60);
		avl.add(80);
		avl.add(75);
		avl.add(85);
		return avl;
	}
	
	private static AVL createLR() {
		AVL avl = new AVL();
		avl.add(50);
		avl.add(30);
		avl.add(70);
		avl.add(20);
		avl.add(40);
		avl.add(35);
		avl.add(45);
		return avl;
	}
	
	
	private static AVL createRL() {
		AVL avl = new AVL();
		avl.add(50);
		avl.add(30);
		avl.add(70);
		avl.add(60);
		avl.add(80);
		avl.add(55);
		avl.add(65);
		return avl;
	}
	
	public static void main(String[] args) {
		testAddLevelOrder();

	}
	
	public static void testAddLevelOrder() {
		System.out.println("AVLTest.testAddLevelOrder()");
		
		AVL avl = createLL();
		avl.levelOrder();
		
		avl = createRR();
		avl.levelOrder();
		
		avl = createLR();
		avl.levelOrder();
		
		avl = createRL();
		avl.levelOrder();
		
	}

}
