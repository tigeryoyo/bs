package 小米;

/**
 * 从前序、中序序列重建二叉树
 * 
 * @author Chan
 *
 */
public class xiaomi_3 {

	public static void main(String[] args) {
		// 前序序列
		int[] pre = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		// 中序序列
		int[] mid = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };
		// 重构二叉树
		BTree root = build(pre, mid, 0, 8, 0);
		// 前序遍历，验证正确性
		BTree.pre_print(root);
	}

	/**
	 * 
	 * @param pre
	 *            先序序列数组
	 * @param mid
	 *            中序序列数组
	 * @param start
	 *            子树的根节点在数组中的位置
	 * @param end
	 *            子树的最后一个节点在数组中的位置
	 * @param first
	 *            根节点在数组中的位置
	 * @return
	 */
	static BTree build(int[] pre, int mid[], int start, int end, int first) {
		if (start == end) {
			return null;
		}
		if (start > first) {
			first = start;
		}
		// middle是左右子树的分界点位置
		int middle = -1;
		for (int i = start; i < end; i++) {
			if (mid[i] == pre[first]) {
				middle = i;
				break;
			}
		}
		BTree root = new BTree(pre[first]);
		// first是根的位置
		root.left = build(pre, mid, start, middle, first + 1);
		root.right = build(pre, mid, middle + 1, end, first + 1);
		return root;
	}
}

class BTree {
	BTree left;
	BTree right;
	int val;

	public BTree(int val) {
		this.val = val;
	}

	// 前序遍历
	public static void pre_print(BTree root) {
		if (root != null) {
			System.out.print(root.val + " ");
			pre_print(root.left);
			pre_print(root.right);
		}
	}
}
