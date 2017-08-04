package 笔试;

public class 二叉树高度 {

	public static void main(String[] args) {
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
		
		System.out.println(getHeight(root));
	}

	public static int getHeight(BinaryTree root) {
		if (root == null) {
			return 0;
		}
		int l = getHeight(root.lchild) + 1;
		int r = getHeight(root.rchild) + 1;

		return l > r ? l : r;
	}

}
