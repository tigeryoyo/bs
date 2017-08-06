package 牛客616;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * @author tigerto
 *
 */
public class Main29 {
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int r = array[0];
		int c = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] != r) {
				c--;
				if (c == 0) {
					r = array[i];
					c = 1;
				}
			} else {
				c++;
			}
		}
		c = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == r) {
				c++;
			}
		}

		return c > array.length / 2 ? r : 0;
	}
}
