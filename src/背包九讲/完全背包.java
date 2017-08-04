package 背包九讲;

import java.util.Scanner;

public class 完全背包 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int v = in.nextInt();
			// 第i件物品,价值为gVal[i],占用容量gCos[i]
			int[] gVal = new int[n + 1];
			int[] gCos = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				gVal[i] = in.nextInt();
				gCos[i] = in.nextInt();
			}
			// 一维数组
			int[] dp = new int[v + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= v; j++) {
					dp[j] = j - gCos[i] >= 0 ? Math.max(dp[j], dp[j - gCos[i]] + gVal[i]) : dp[j];
				}
			}
			System.out.println(dp[v]);
			// 二维数组
			int[][] dp2 = new int[n + 1][v + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= v; j++) {
					dp2[i][j] = j - gCos[i] >= 0 ? Math.max(dp2[i - 1][j], dp2[i][j - gCos[i]] + gVal[i])
							: dp2[i - 1][j];
				}
			}
			System.out.println(dp2[n][v]);
		}
		in.close();
	}

}
