package leetcode;

/**
 * Given a binary tree, find its minimum depth. The minimum depth is the number
 * of nodes along the shortest path from the root node down to the nearest leaf
 * node.
 * 
 * @author tigerto
 *
 */
public class minimum_depth_of_binary_tree {
	public int run(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return run(root.right) + 1;
		}
		if (root.right == null) {
			return run(root.left) + 1;
		}
		int l = run(root.left);
		int r = run(root.right);
		return Math.min(l + 1, r + 1);
	}
}
