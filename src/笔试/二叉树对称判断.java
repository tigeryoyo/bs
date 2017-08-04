package 笔试;

public class 二叉树对称判断 {
	
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(0);
		root.lchild = new BinaryTree(1);
		root.rchild = new BinaryTree(1);
		root.lchild.lchild = new BinaryTree(3);
		root.lchild.rchild = new BinaryTree(4);
		root.rchild.lchild = new BinaryTree(4);
		root.rchild.rchild = new BinaryTree(4);
		System.out.println(isSymmetric(root));
	}
	
	public static boolean isSymmetric(BinaryTree root) {
		return root==null || isSymmetric(root.lchild,root.rchild);
	}
	
	public static boolean isSymmetric(BinaryTree l,BinaryTree r){
		if(l==null||r==null){
			return l==r;
		}
		if(l.value != r.value){
			return false;
		}
		return isSymmetric(l.lchild, r.rchild) && isSymmetric(l.rchild, r.lchild);
	}
}
