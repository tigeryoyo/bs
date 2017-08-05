package 牛客616;

import java.util.Stack;

public class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	TreeNode(int val) {
		this.val = val;
		left = right = null;
	}

	public static void main(String[] args) {
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
		post_print(root);
		System.out.println();
		_post_print(root);
	}

	public static void visit(TreeNode node) {
		System.out.print(node.val + " ");
	}

	// 前序遍历
	public static void pre_print(TreeNode root) {
		if (root != null) {
			visit(root);
			pre_print(root.left);
			pre_print(root.right);
		}
	}

	public static void _pre_print(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
			stack.push(root);
			while (!stack.isEmpty()) {
				root = stack.pop();
				visit(root);
				if (root.right != null) {
					stack.push(root.right);
				}
				if (root.left != null) {
					stack.push(root.left);
				}
			}
		}

	}

	// 中序遍历
	public static void mid_print(TreeNode root) {
		if (root != null) {
			mid_print(root.left);
			visit(root);
			mid_print(root.right);
		}
	}

	public static void _mid_print(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			visit(root);
			root = root.right;
		}
	}

	// 后序遍历
	public static void post_print(TreeNode root) {
		if (root != null) {
			post_print(root.left);
			post_print(root.right);
			visit(root);
		}
	}

	public static void _post_print(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		boolean visited = false;
		while (!stack.isEmpty() || root != null) {
			while (root != null && !visited) {
				stack.push(root);
				root = root.left;
			}
			TreeNode top = stack.peek();
			if(top.right != null && !visited){
				root = top.right;
				visited = false;
			} else {
				TreeNode q= stack.pop();
				visit(q);
				//如果当前根节点被访问了，而它的右节点不为空，则说明该根节点的右子树已经访问完毕。
				if(q.right != null){
					visited = false;
				}
				if(stack.isEmpty()){
					break;
				}
				//假如此时遍历的是根节点的右子树根节点
				root = stack.peek().right;
				if(root == q){
					visited = true;
				}
			}
		}
	}
}
