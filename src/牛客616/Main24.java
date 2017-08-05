package 牛客616;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author tigerto
 *
 */
public class Main24 {

	public static void main(String[] args) {
		System.out.println(VerifySquenceOfBST(new int[] { 4, 6, 5 }));
	}

	public static boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length == 0) {
			return false;
		}
		return fun(sequence, 0, sequence.length - 1);
	}

	public static boolean fun(int[] sequence, int start, int end) {
		if (start >= end) {
			return true;
		}
		int root = sequence[end];
		int i = start;
		for (; i < end; i++) {
			if (sequence[i] > root) {
				break;
			}
		}
		int j = i;
		for (; j < end; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}
		return fun(sequence, start, i - 1) && fun(sequence, i, end - 1);
	}
}
