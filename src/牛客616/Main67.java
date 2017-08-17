package 牛客616;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 =
 * 19。请问该机器人能够达到多少个格子？
 * 
 * @author Chan
 *
 */
public class Main67 {

	public int movingCount(int threshold, int rows, int cols) {
		boolean[][] flag = new boolean[rows][cols];
		return movingCount(threshold, rows, cols, 0, 0, flag);

	}

	public int movingCount(int threshold, int rows, int cols, int i, int j, boolean[][] flag) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] || judge(i, j, threshold)) {
			return 0;
		}
		flag[i][j] = true;
		return 1 + movingCount(threshold, rows, cols, i - 1, j, flag) + movingCount(threshold, rows, cols, i + 1, j, flag)
				+ movingCount(threshold, rows, cols, i, j - 1, flag) + movingCount(threshold, rows, cols, i, j + 1, flag);
	}

	private boolean judge(int i, int j, int threshold) {
		return threshold < convert(i) + convert(j);
	}

	private int convert(int i) {
		int res = 0;
		while (i != 0) {
			res += i % 10;
			i /= 10;
		}
		return res;
	}
}
