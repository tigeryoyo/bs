package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 最长升序子序列 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			// dp[i]表示以arr[i]结尾的最长上升子序列
			int[] dp = new int[n];
			Arrays.fill(dp, 1);
			int max = 1;
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j] && dp[j] >= dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
				max = Math.max(dp[i], max);
			}
			System.out.println(max);
		}
		in.close();
	}
}
