package 笔试;

public class 二叉平衡树判断 {

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(0);
		root.lchild = new BinaryTree(1);
		root.rchild = new BinaryTree(5);
		root.rchild.rchild = new BinaryTree(5);
	//	root.rchild.rchild.lchild = new BinaryTree(5);
		System.out.println(judge(root));
	}

	// 默认为平衡二叉树
//	static boolean flag = true;

	public static int judge(BinaryTree root) {
		if (root == null) {
			return 0;
		}
		int l = judge(root.lchild);
		int r = judge(root.rchild);
		if (Math.abs(l - r) > 1) {
			return -1;
		}else{
			return l > r ? l + 1 : r + 1;
		}
	}

}
