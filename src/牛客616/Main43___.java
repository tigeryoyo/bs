package 牛客616;

import java.util.ArrayList;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之后为s。输入n，打印出s的所有可能的值出现的概率。
 * 
 * @author tigerto
 *
 */
public class Main43___ {

	public static void main(String[] args) {
		new Main43___().getProb(10);
	}

	/**
	 * 非递归
	 * 
	 * @param n
	 * @return
	 */
	public ArrayList<Double> getProb(int n) {
		int[][] p = new int[2][6 * n + 1];

		for (int i = 1; i <= 6; i++) {
			p[0][i] = 1;
		}

		int flag = 0;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				// 当骰子数量为j的时候，小于骰子数的结果不存在故为0
				p[1 - flag][j] = 0;
			}

			for (int j = i; j <= i * 6; j++) {
				p[1 - flag][j] = 0;
				for (int k = 1; k <= j && k <= 6; k++) {
					p[1 - flag][j] += p[flag][j - k];
				}
			}
			flag = 1 - flag;
		}

		return null;
	}

	public void getP(int n) {
		int[] p = new int[6 * n + 1];
		
	}
}
