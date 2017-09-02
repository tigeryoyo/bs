package 小米;

import java.util.*;

/**
 * 二分查找
 * 条件一：如果查找到的重复元素则返回第一个
 * 条件二：如果查找的元素没有找到则返回该元素的插入位置
 * @author Chan
 *
 */
public class xiaomi_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int[] arr = new int[] { 2, 2, 2,  2, 5, 6, 8 };
			// 输入一个想要查找的key值
			int key = in.nextInt();
			System.out.println("返回的位置是（从0开始）: "+lowerBound(arr,key));
		}
		in.close();
	}

	static int lowerBound(int[] arr, int key) {
		int low = 0, high = arr.length;
		while (low < high) {
			int mid = (low + high) >> 1;
			if (arr[mid] >= key) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}
