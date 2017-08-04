package 笔试;

import java.util.Scanner;

public class 排列 {
	static boolean[] flag;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			flag = new boolean[n];
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = in.nextInt();
			}
			int[] res = new int[n];
			pailie(nums, 0, res);
		}
		in.close();
	}

	// 1~n, 子问题：每次确定一位数，第deep层确定第deep个数
	public static void pailie(int[] nums, int deep, int[] res) {
		if (deep == res.length) {
			for (int i : res) {
				System.out.print(i);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!flag[i]) {
				res[deep] = nums[i];
				flag[i] = true;
				pailie(nums, deep + 1, res);
				flag[i] = false;
			}
		}
	}

}
