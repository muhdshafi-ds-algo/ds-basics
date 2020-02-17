package avl;

public class AVLNode {
	AVLNode left, right;
	int value, height;

	public AVLNode() {
	}

	public AVLNode(int value) {
		this.value = value;
		this.height = 1;
	}

	@Override
	public String toString() {

		return "{ " + left + ", " + value + ", " + right + "}";
	}
}
