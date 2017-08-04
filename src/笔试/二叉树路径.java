package 笔试;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 二叉树路径 {

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
		
//		BinaryTree.printTree(root);
		
		BinaryTree node = root.lchild.rchild.lchild;
		System.out.println(node.value);
		BinaryTree[] res = new BinaryTree[10];
		path(root,node,res,0);
		pathA(root,node);
		pathB(root,node);
	}
	
	//递归
	public static void path(BinaryTree root, BinaryTree node, BinaryTree[] res, int deep){
		if(root == null){
			return;
		}
		if(root == node){
			res[deep++] = root;
			for(int i=0; i<deep; i++){
				System.out.print(res[i].value+" ");
			}
			System.out.println();
			return;
		}
		res[deep] = root;
		path(root.lchild,node,res,deep+1);
		path(root.rchild,node,res,deep+1);
	}
	
	//非递归，深度搜索
	public static void pathA(BinaryTree root, BinaryTree node){
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		//标记是否访问过该节点
		boolean[] flag = new boolean[13];
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTree top = stack.peek();
			if(top == node){
				while(!stack.isEmpty()){
					System.out.print(stack.pop().value+" ");
				}
				System.out.println();
			}else{
				BinaryTree l = top.lchild;
				if(l != null && !flag[l.value]){
					stack.push(l);
				}else{
					BinaryTree r = top.rchild;
					if(r != null && !flag[r.value]){
						stack.push(r);
					}else{
						BinaryTree tmp = stack.pop();
						flag[tmp.value] = true;
					}
				}
			}
		}
	}
	
	//宽度搜索
	public static void pathB(BinaryTree root, BinaryTree node){
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.offer(root);
		int[] path = new int[13];
		for(int i=0; i<path.length; i++){
			path[i] = -1;
		}
		while(!queue.isEmpty()){
			BinaryTree cur = queue.poll();
			if(cur == node){
				int k = cur.value;
				do{
					System.out.print(k+" ");
					k = path[k];
				}while(k!=-1);
			}else{
				BinaryTree l = cur.lchild;
				if(l != null){
					path[l.value] = cur.value;
					queue.offer(l);
				}
				
				BinaryTree r = cur.rchild;
				if(r != null){
					path[r.value] = cur.value;
					queue.offer(r);
				}
			}
		}
		
	}

}
