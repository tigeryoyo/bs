package 牛客616;

/**
 * 根据先序、中序序列重构二叉树
 * 
 * @author Chan
 *
 */
public class Main06 {

	public static void main(String[] args) {
		int[] pre = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] mid = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode root = build(pre, mid, 0, 8, 0);
		TreeNode.pre_print(root);
		System.out.println();
		TreeNode.mid_print(root);
		System.out.println();
		TreeNode.post_print(root);
	}

	public static TreeNode build(int[] pre, int mid[], int start, int end, int first) {
		if (start == end) {
			return null;
		}
		if (start > first) {
			first = start;
		}
		int middle = -1;
		for (int i = start; i < end; i++) {
			if (mid[i] == pre[first]) {
				middle = i;
				break;
			}
		}
		TreeNode root = new TreeNode(pre[first]);
		root.left = build(pre, mid, start, middle, first + 1);
		root.right = build(pre, mid, middle + 1, end, first + 1);
		return root;
	}

}
