package leetcode;

import java.util.*;

public class binary_tree_postorder {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				list.add(node.val);
				if (node.left != null) {
					stack.push(node.left);
				}
				if (node.right != null) {
					stack.push(node.right);
				}
			}
			Collections.reverse(list);
		}
		return list;
	}
}
