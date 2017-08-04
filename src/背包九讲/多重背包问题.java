package 背包九讲;

import java.util.Scanner;

public class 多重背包问题 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int v = in.nextInt();
			// 第i件物品,价值为gVal[i],占用容量gCos[i]
			int[] gVal = new int[n + 1];
			int[] gCos = new int[n + 1];
			int[] gNum = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				gVal[i] = in.nextInt();
				gCos[i] = in.nextInt();
				gNum[i] = in.nextInt();
			}
			// 一维数组
			int[] dp = new int[v + 1];
			for (int i = 1; i <= n; i++) {
				for (int k = 1; k <= gNum[i]; k++) {
					for (int j = v; j >= gCos[i]; j--) {
						dp[j] = Math.max(dp[j], dp[j - gCos[i]] + gVal[i]);
					}
				}
			}
			System.out.println(dp[v]);
			// 二维数组
			int[][] dp2 = new int[n + 1][v + 1];
			for (int i = 1; i <= n; i++) {
				for (int k = 1; k <= gNum[i]; k++) {
					for (int j = v; j >= gCos[i]; j--) {
						// if (k != 1) {
						// dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i][j -
						// gCos[i]] + gVal[i]);
						// } else {
						// dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i - 1][j -
						// gCos[i]] + gVal[i]);
						// }
						if (k * gCos[i] <= j) {
							dp2[i][j] = Math.max(dp2[i-1][j], dp2[i-1][j - gCos[i] * k] + gVal[i] * k);
						} else {
							break;
						}
					}
				}
			}
			System.out.println(dp2[n][v]);

		}
		in.close();
	}

}
