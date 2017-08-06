package 牛客616;

import java.util.Scanner;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * @author tigerto
 *
 */
public class Main03 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int k = in.nextInt();
			int c = 0;

			int most = 0;
			int t = n - 1;
			for (int i = 0; i < k; i++) {
				most += t;
				t--;
			}

			for (int i = n; i <= most; i += n) {
				int[] res = new int[k];
			}

			System.out.println(c % 1000000007);
		}
		in.close();
	}

	public static int getCount(int start, int n, int k, int sum) {

		return 0;
	}

}
