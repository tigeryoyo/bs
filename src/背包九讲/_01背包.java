package 背包九讲;

import java.util.Scanner;

public class _01背包 {

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
			// 情形一：不一定装满背包
			int[][] dp1 = new int[n + 1][v + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= v; j++) {
					dp1[i][j] = j - gCos[i] >= 0 ? Math.max(dp1[i - 1][j], dp1[i - 1][j - gCos[i]] + gVal[i])
							: dp1[i - 1][j];
				}
			}
			System.out.println("最大价值：" + dp1[n][v]);

			// 情形二：必须装满背包
			int[][] dp2 = new int[n + 1][v + 1];
			// 想想dp[i][j]代表什么,就明白为什么这么初始化
			for (int j = 1; j <= v; j++) {
				dp2[0][j] = Integer.MIN_VALUE;
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= v; j++) {
					dp2[i][j] = j - gCos[i] >= 0 ? Math.max(dp2[i - 1][j], dp2[i - 1][j - gCos[i]] + gVal[i])
							: dp2[i - 1][j];
				}
			}
			System.out.println("背包装满的最大价值：" + dp2[n][v]);
			

			// 一维数组写法情形一
			int[] dp1a = new int[v + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = v; j >= gCos[i]; j--) {
					dp1a[j] = Math.max(dp1a[j], dp1a[j - gCos[i]] + gVal[i]);
				}
			}
			System.out.println(dp1a[v]);
			// 一维数组写法情形二
			int[] dp2a = new int[v + 1];
			for(int i=1; i<=v; i++){
				dp2a[i] = Integer.MIN_VALUE;
			}
			for (int i = 1; i <= n; i++) {
				for (int j = v; j >= gCos[i]; j--) {
					dp2a[j] = Math.max(dp2a[j], dp2a[j - gCos[i]] + gVal[i]);
				}
			}
			System.out.println(dp2a[v]);
		}
		in.close();
	}

}
