package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 二叉平衡排序树构建 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = in.nextInt();
			}
			Arrays.sort(nums);
			BinaryTree root = build(nums, 0, n);
			BinaryTree.printPreOrderTree(root);
		}
		in.close();
	}

	public static BinaryTree build(int[] nums, int start, int end) {
		if (start >= end)
			return null;
		int mid = (start + end) / 2;
		BinaryTree root = new BinaryTree(nums[mid]);
		root.lchild = build(nums, start, mid);
		root.rchild = build(nums, mid + 1, end);
		return root;
	}
}

class BinaryTree {
	int value;
	BinaryTree lchild;
	BinaryTree rchild;

	public BinaryTree(int value) {
		this.value = value;
	}
	
	public static void printPreOrderTree(BinaryTree root){
		if(root != null){
			System.out.print(root.value+" ");
			printPreOrderTree(root.lchild);
			printPreOrderTree(root.rchild);
		}
	}
	public static void printInOrderTree(BinaryTree root){
		if(root != null){
			printInOrderTree(root.lchild);
			System.out.print(root.value+" ");
			printInOrderTree(root.rchild);
		}
	}
	public static void printPostOrderTree(BinaryTree root){
		if(root != null){
			printPostOrderTree(root.lchild);
			printPostOrderTree(root.rchild);
			System.out.print(root.value+" ");
		}
	}
}
