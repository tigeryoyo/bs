package 牛客616;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author Chan
 *
 */
public class Main33 {
	
	/**
	 * 高级解法
	 * 解题思路：
	 * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。
	 * 关键就是制定排序规则。
	 * 排序规则如下：
	 * 若ab > ba 则 a > b，
	 * 若ab < ba 则 a < b，
	 * 若ab = ba 则 a = b；
	 * 解释说明：
	 * 比如"3"<"31"但是"331">"313"，所以要将二者拼接起来进行比较
	 */
	public String PrintMinNumber1(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			return "";
		int len = numbers.length;
		String[] str = new String[len];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String c1 = s1 + s2;
				String c2 = s2 + s1;
				return c1.compareTo(c2);
			}
		});
		for (int i = 0; i < len; i++) {
			sb.append(str[i]);
		}
		return sb.toString();
	}
	
	public String PrintMinNumber(int[] numbers) {
		ArrayList<String> res = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		if (numbers == null || numbers.length == 0) {
			return "";
		}
		fun(numbers, 0, set);
		res.addAll(set);
		Collections.sort(res);
		return res.get(0);
	}

	public void fun(int[] nums, int i, HashSet<String> set) {
		if (i == nums.length - 1) {
			StringBuilder sb = new StringBuilder();
			for (int str : nums) {
				sb.append(str);
			}
			String t = sb.toString();
			if (!set.contains(t)) {
				set.add(t);
			}
		} else {
			for (int j = i; j < nums.length; j++) {
				swap(nums, i, j);
				fun(nums, i + 1, set);
				swap(nums, i, j);
			}
		}
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}