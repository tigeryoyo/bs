package 牛客616;

import java.util.*;

public class 之字形打印二叉树 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		if (pRoot == null) {
			return null;
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Stack<TreeNode> odd = new Stack<TreeNode>();
		Stack<TreeNode> even = new Stack<TreeNode>();
		odd.add(pRoot);
		int layer = 1;
		ArrayList<Integer> tmp = null;
		while (!odd.isEmpty() || !even.isEmpty()) {
			if (layer % 2 != 0) {
				tmp = new ArrayList<Integer>();
				while (!odd.isEmpty()) {
					TreeNode node = odd.pop();
					tmp.add(node.val);
					if (node.left != null) {
						even.add(node.left);
					}
					if (node.right != null) {
						even.add(node.right);
					}
				}
			} else {
				tmp = new ArrayList<Integer>();
				while (!even.isEmpty()) {
					TreeNode node = even.pop();
					tmp.add(node.val);
					if (node.right != null) {
						odd.add(node.right);
					}
					if (node.left != null) {
						odd.add(node.left);
					}
				}
			}
			if (!tmp.isEmpty()) {
				layer++;
				list.add(tmp);
			}
		}
		return list;
	}
}
