package example.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import example.tree.demo.TreeNode;

public class AN {

	public static void main(String[] args) {
		
		TreeNode root_A = new TreeNode(1);
		TreeNode l1_A = new TreeNode(2);
		root_A.left = l1_A;
		TreeNode r1_A = new TreeNode(3);
		root_A.right = r1_A;
		
		TreeNode l1l2_A = new TreeNode(4);
		l1_A.left = l1l2_A;
		TreeNode l1r2_A = new TreeNode(5);
		l1_A.right = l1r2_A;
		
		
		TreeNode root_B = new TreeNode(6);
		TreeNode l1_B = new TreeNode(7);
		root_B.left = l1_B;
		TreeNode r1_B = new TreeNode(8);
		root_B.right = r1_B;
		
		TreeNode l1l2_B = new TreeNode(9);
		l1_B.left = l1l2_B;
		TreeNode l1r2_B = new TreeNode(10);
		l1_B.right = l1r2_B;

		
		TreeNode root_C = new TreeNode(6);
		TreeNode l1_C = new TreeNode(7);
		root_C.left = l1_C;
		TreeNode r1_C = new TreeNode(8);
		root_C.right = r1_C;
		
		TreeNode l1l2_C = new TreeNode(9);
		l1_C.left = l1l2_C;
		
		TreeNode root_D = new TreeNode(1);
		TreeNode l1_D = new TreeNode(2);
		root_D.left = l1_D;
		TreeNode r1_D = new TreeNode(3);
		root_D.right = r1_D;
		
		TreeNode l1l2_D = new TreeNode(4);
		l1_D.left = l1l2_D;
		TreeNode l1r2_D = new TreeNode(5);
		l1_D.right = l1r2_D;
		
		System.out.println("A == B : "+checkStructuralyEqual(root_A, root_B));
		System.out.println("A == C : "+checkStructuralyEqual(root_A, root_C));
		System.out.println("A === B : "+checkEqual(root_A, root_B));
		System.out.println("A === D : "+checkEqual(root_A, root_D));
		System.out.println("A === B non rec : "+checkEqualNonRec(root_A, root_B));
		System.out.println("A === D non rec : "+checkEqualNonRec(root_A, root_D));
	}

	/**
	 * level order
	 * @param root_A
	 * @param root_B
	 * @return
	 */
	private static boolean checkEqualNonRec(TreeNode a, TreeNode b) {
		
		if(a == null && b == null) {
			return true;
		}
		
		if(a == null || b == null) {
			return false;
		}
		
		Queue<TreeNode> qa = new LinkedList<>();
		Queue<TreeNode> qb = new LinkedList<>();
		qa.add(a);
		qb.add(b);
		//level order - partial implementation
		while(!qa.isEmpty() && !qb.isEmpty()) {
			TreeNode ta = qa.poll();
			TreeNode tb = qb.poll();
			
			if(ta.value != tb.value) {
				return false;
			}
			
			if(ta.left != null && tb.left != null) {
				qa.add(ta.left);
				qb.add(tb.left);
			}else if(ta.left != null || tb.left != null) {
				return false;
			}
			
			if(ta.right != null && tb.right!= null) {
				qa.add(ta.right);
				qb.add(tb.right);
			}else if(ta.right != null || tb.right!= null) {
				return false;
			}
		}
		
		return true;

	}

	private static boolean checkEqual(TreeNode root_A, TreeNode root_B) {
		
		if(root_A == null && root_B == null) {
			return true;
		}
		
		if((root_A != null && root_B != null)) {
			//System.out.println(root_A.value +"=="+ root_B.value);
			return checkEqual(root_A.left, root_B.left) 
					&& checkEqual(root_A.right, root_B.right)
					&& root_A.value == root_B.value ;
		}
		
		return  false;
	}

	private static boolean  checkStructuralyEqual(TreeNode root_A, TreeNode root_B) {
		
		if(root_A == null && root_B == null) {
			return true;
		}
		
		if((root_A != null && root_B != null)) {
			return checkStructuralyEqual(root_A.left, root_B.left) 
					&& checkStructuralyEqual(root_A.right, root_B.right);
		}
		
		return  false;
		
	}
}
