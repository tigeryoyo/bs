package 笔试;

public class LatestCommonAncestors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree root = new Tree(1);
		root.lchild = insert(2);
		root.rchild = insert(3);
		root.lchild.lchild = insert(4);
		root.lchild.rchild = insert(5);
		root.rchild.lchild = insert(6);
		root.rchild.rchild = insert(7);
		root.lchild.rchild.rchild = insert(8);
		root.lchild.rchild.rchild.lchild = insert(9);
		Tree[] route = new Tree[10];
		getTraceRoute(root, root.lchild.rchild.rchild.lchild, 0, route);
		for (Tree node : route) {
			if (node == null) {
				break;
			}
			System.out.println(node.value);
		}
	}

	static boolean flag = true;
	private static void getTraceRoute(Tree root, Tree node, int deep, Tree[] route) {
		if (root == null) {
			return;
		}
		if(flag){
			route[deep] = root;
		}
		if (root == node) {
			flag = false;
			return;
		}
			getTraceRoute(root.lchild, node, deep + 1, route);
			getTraceRoute(root.rchild, node, deep + 1, route);
	}

	static Tree lca = null;

	private static void getLCA(Tree root, Tree l, Tree r) {
		if (root == null) {
			return;
		}
		if (trace(root.lchild, l) && trace(root.rchild, r) || trace(root.lchild, r) && trace(root.rchild, l)) {
			lca = root;
			return;
		} else {
			getLCA(root.lchild, l, r);
			getLCA(root.rchild, l, r);
		}
	}

	private static boolean trace(Tree root, Tree node) {
		if (root == null) {
			return false;
		}
		if (root == node) {
			return true;
		} else {
			return trace(root.lchild, node) || trace(root.rchild, node);
		}
	}

	private static Tree insert(int value) {
		Tree node = new Tree(value);
		return new Tree(value);
	}

}

class Tree {
	int value;
	Tree lchild;
	Tree rchild;

	Tree(int value) {
		this.value = value;
		lchild = rchild = null;
	}
}
