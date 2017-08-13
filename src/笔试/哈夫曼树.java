package 笔试;


import java.util.*;

public class 哈夫曼树 {
	/** 请完成下面这个函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/
	static int cut(int[] parts) {
		int res = 0;
		if (parts.length < 2) {
			return res;
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i : parts) {
			queue.add(i);
		}
		while (!queue.isEmpty()) {
			TreeNode_ node = new TreeNode_(0);
			int lval = queue.poll();
			if (queue.isEmpty()) {
				break;
			}
			int rval = queue.poll();
			node.lchild = new TreeNode_(lval);
			node.rchild = new TreeNode_(rval);
			node.val = lval + rval;
			res += node.val;
			queue.add(node.val);
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int pieces = Integer.parseInt(in.nextLine().trim());
		int[] parts = new int[pieces];
		for (int i = 0; i < pieces; i++) {
			parts[i] = Integer.parseInt(in.nextLine().trim());
		}
		System.out.println(cut(parts));
	}

}

class TreeNode_ {
	TreeNode_ lchild;
	TreeNode_ rchild;

	int val;

	TreeNode_(int val) {
		this.val = val;
	}
}
