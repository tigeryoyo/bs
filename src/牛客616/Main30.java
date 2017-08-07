package 牛客616;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * @author tigerto
 *
 */
public class Main30 {

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (input == null || input.length == 0 || k < 0 || k > input.length) {
			return res;
		}
		int index = partition(input, 0, input.length - 1);
		int start = 0;
		int end = input.length - 1;
		while (start <= end) {
			if (index > k - 1) {
				end = index - 1;
				index = partition(input, start, end);
			} else if (index < k - 1) {
				start = index + 1;
				index = partition(input, start, end);
			} else {
				break;
			}
		}
		for (int i = 0; i < k; i++) {
			res.add(input[i]);
		}
		Collections.sort(res);
		return res;
	}

	private int partition(int[] input, int start, int end) {
		int p = input[start];
		while (start < end) {
			while (start < end && input[end] >= p)
				end--;
			input[start] = input[end];
			while (start < end && input[start] <= p)
				start++;
			input[end] = input[start];
		}
		input[start] = p;
		return start;
	}
}
