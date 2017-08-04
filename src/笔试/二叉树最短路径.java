package 笔试;

public class 二叉树最短路径 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree root = new BinaryTree(0);
		root.lchild = new BinaryTree(1);
		root.rchild = new BinaryTree(2);
		root.lchild.lchild = new BinaryTree(3);
		root.lchild.rchild = new BinaryTree(4);
		root.lchild.lchild.lchild = new BinaryTree(7);
		root.lchild.lchild.lchild.lchild = new BinaryTree(9);
		root.lchild.lchild.lchild.lchild.lchild = new BinaryTree(11);
		root.lchild.lchild.lchild.lchild.lchild.lchild = new BinaryTree(12);
		root.rchild.lchild = new BinaryTree(5);
		root.rchild.rchild = new BinaryTree(6);
		root.lchild.rchild.lchild = new BinaryTree(8);
		root.lchild.rchild.lchild.lchild = new BinaryTree(10);
		System.out.println(getMin(root));
	}

	public static int getMin(BinaryTree root) {
		if (root == null) {
			return 0;
		}
		int l = getMin(root.lchild);
		int r = getMin(root.rchild);

		return (l == 0 || r == 0) ? l + r + 1 : Math.min(l + 1, r + 1);
	}
}
