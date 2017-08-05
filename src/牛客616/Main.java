package 牛客616;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] a = new int[n][2];
			int[][] k = new int[m][2];

			for (int i = 0; i < n; i++) {
				a[i] = new int[2];
				// 生命值
				a[i][0] = in.nextInt();
				// 防御力
				a[i][1] = in.nextInt();
			}

			// 先按防御力从小到大排序，再防御生命值比从小到大排序
			Arrays.sort(a, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					int c = o1[1] - o2[1];
					if (c == 0) {
						double r = (double) o1[0] / o1[1] - (double) o2[0] / o2[1];
						if (r > 0) {
							return -1;
						} else {
							return 1;
						}
					}
					return c;
				}

			});

			for (int i = 0; i < m; i++) {
				k[i] = new int[n];
				// 水晶
				k[i][0] = in.nextInt();
				// 伤害
				k[i][1] = in.nextInt();
			}

			// 先按伤害从小到大排序，再按伤害水晶比从小到大排序
			Arrays.sort(k, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					int c = o1[1] - o2[1];
					if (c == 0) {
						double r = (double) o1[0] / o1[1] - (double) o2[0] / o2[1];
						if (r > 0) {
							return -1;
						} else {
							return 1;
						}
					}
					return c;
				}

			});
			
			
			
			

		}
		in.close();
	}

}
