package 牛客616;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的最近公共祖先
 * 
 * @author tigerto
 *
 */
public class Main50 {

	public static void main(String[] args) {
		Main50 m = new Main50();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.left.left = new TreeNode(7);
		root.left.right.left.right = new TreeNode(8);
		root.left.right.left.right.left = new TreeNode(9);
		root.left.right.left.right.right = new TreeNode(10);

		TreeNode a = root.left.right.left.right.left;
		TreeNode b = root.left.right.left.right.right;

		m.getLCT(root, a, b);
	}

	public TreeNode getLCT(TreeNode root, TreeNode a, TreeNode b) {
		ArrayList<TreeNode> ar = new ArrayList<TreeNode>();
		ArrayList<TreeNode> br = new ArrayList<TreeNode>();
		travel(root, a, 0, ar);
		ar = g_res;
		travel(root, b, 0, br);
		br = g_res;
		for (TreeNode i : ar) {
			System.out.print(i.val + " ");
		}
		System.out.println();
		for (TreeNode i : br) {
			System.out.print(i.val + " ");
		}

		return null;
	}
	
	public ArrayList<TreeNode> g_res;

	public void travel(TreeNode root, TreeNode a, int deep, List<TreeNode> res) {
		if (root == a) {
			res.add(root);
			g_res = new ArrayList<TreeNode>(res);
			return;
		}
		if (root != null) {
			res.add(root);
			travel(root.left, a, deep + 1, res);
			travel(root.right, a, deep + 1, res);

			res.remove(deep);
		}
	}
}
