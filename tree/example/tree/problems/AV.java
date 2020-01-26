package example.tree.problems;

import example.tree.demo.TreeNode;

/*            1
             / \
           2     3
          / \   / \
         4   5 6   7
    
         pre = 1245367 
         in  = 4251637 
         post= 4526731 
        
   
    * 1. 1st element in pre order is the root
    * 2. find the root in inorder and calculate Offset(number of elements in left sub tree)
    * 3. split both into 2 using the offset value
    * 4. repeat recursively
    *       
    *       
    * @author king
    *
    */
         
public class AV {

	public static void main(String[] args) {

		int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };

		TreeNode root = buildTreeFromPerorderInorder(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
		TreeNode.printLevelOrder(root);

		int[] inorder2 = { 8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15 };
		int[] preorder2 = { 1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15 };
		int[] postorder2 = { 8, 9, 4, 10, 11, 5, 2, 12, 13, 6, 14, 15, 7, 3, 1 };

		root = buildTreeFromPerorderInorder(inorder2, preorder2, 0, inorder2.length - 1, 0, preorder2.length - 1);
		TreeNode.printLevelOrder(root);
		
		root = buildTreeFromPostorderInorder(inorder2, postorder2, 0, inorder2.length - 1, 0, postorder2.length - 1);
		TreeNode.printLevelOrder(root);
	}

	public static TreeNode buildTreeFromPerorderInorder(int[] inorder, int[] preorder, int startIn, int endIn, int startPre, int endPre) {
		
		if (startIn > endIn || startPre > endPre || (inorder.length != preorder.length) || inorder.length == 0) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[startPre]);
		int offset = findOffset(preorder[startPre], startIn, endIn, inorder);
		node.left = buildTreeFromPerorderInorder(inorder, 
												 preorder, 
												 startIn, 
												 startIn + offset - 1, 
												 startPre + 1,
												 startPre + offset);
		
		node.right = buildTreeFromPerorderInorder(inorder, 
												  preorder, 
												  startIn + offset + 1, 
												  endIn, 
												  startPre + offset + 1, 
												  endPre);
		return node;

	}
	
	
	public static TreeNode buildTreeFromPostorderInorder(int[] inorder, int[] postorder, int startIn, int endIn, int startPost, int endPost) {
		
		if (startIn > endIn || startPost > endPost || (inorder.length != postorder.length) || inorder.length == 0) {
			return null;
		}

		TreeNode node = new TreeNode(postorder[endPost]);
		int offset = findOffset(postorder[endPost], startIn, endIn, inorder);
		node.left = buildTreeFromPostorderInorder(inorder, 
												 postorder, 
												 startIn, 
												 startIn + offset - 1, 
												 startPost,
												 startPost + offset - 1);
		
		node.right = buildTreeFromPostorderInorder(inorder, 
												  postorder, 
												  startIn + offset + 1, 
												  endIn, 
												  startPost + offset, 
												  endPost - 1);
		return node;

	}
	
	public static int findOffset(int value, int start, int end, int[] inorder) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			if (inorder[i] == value) {
				break;
			}
			count++;
		}
		return count;
	}
	
}
