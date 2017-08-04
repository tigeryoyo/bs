package 笔试;

import java.util.Stack;

public class 二叉树遍历 {
	public static void main(String[] args) {
		BTree root = new BTree(1);
		root.lchild = new BTree(2);
		root.rchild = new BTree(3);
		root.lchild.lchild = new BTree(4);
		root.lchild.rchild = new BTree(5);
		root.lchild.rchild.lchild = new BTree(6);
		root.lchild.rchild.lchild.lchild = new BTree(7);
		root.lchild.rchild.lchild.rchild = new BTree(8);
		root.lchild.rchild.lchild.rchild.lchild = new BTree(9);
		root.lchild.rchild.lchild.rchild.rchild = new BTree(10);
		BTree.post_print(root);
		System.out.println();
		BTree._post_print(root);
	}

}

class BTree {
	BTree lchild;
	BTree rchild;
	int val;

	BTree(int val) {
		this.val = val;
		lchild = rchild = null;
	}

	public static void visit(BTree node) {
		System.out.print(node.val + " ");
	}

	// 前序遍历
	public static void pre_print(BTree root) {
		if (root != null) {
			visit(root);
			pre_print(root.lchild);
			pre_print(root.rchild);
		}
	}

	public static void _pre_print(BTree root) {
		Stack<BTree> stack = new Stack<BTree>();
		if (root != null) {
			stack.push(root);
			while (!stack.isEmpty()) {
				root = stack.pop();
				visit(root);
				if (root.rchild != null) {
					stack.push(root.rchild);
				}
				if (root.lchild != null) {
					stack.push(root.lchild);
				}
			}
		}

	}

	// 中序遍历
	public static void mid_print(BTree root) {
		if (root != null) {
			mid_print(root.lchild);
			visit(root);
			mid_print(root.rchild);
		}
	}

	public static void _mid_print(BTree root) {
		Stack<BTree> stack = new Stack<BTree>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.lchild;
			}
			root = stack.pop();
			visit(root);
			root = root.rchild;
		}
	}

	// 后序遍历
	public static void post_print(BTree root) {
		if (root != null) {
			post_print(root.lchild);
			post_print(root.rchild);
			visit(root);
		}
	}

	public static void _post_print(BTree root) {
		Stack<BTree> stack = new Stack<BTree>();
		boolean visited = false;
		while (!stack.isEmpty() || root != null) {
			while (root != null && !visited) {
				stack.push(root);
				root = root.lchild;
			}
			BTree top = stack.peek();
			if(top.rchild != null && !visited){
				root = top.rchild;
				visited = false;
			} else {
				BTree q= stack.pop();
				visit(q);
				//如果当前根节点被访问了，而它的右节点不为空，则说明该根节点的右子树已经访问完毕。
				if(q.rchild != null){
					visited = false;
				}
				if(stack.isEmpty()){
					break;
				}
				//假如此时遍历的是根节点的右子树根节点
				root = stack.peek().rchild;
				if(root == q){
					visited = true;
				}
			}
		}
	}
}
