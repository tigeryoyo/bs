package 牛客616;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * @author tigerto
 *
 */
public class Main28___ {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<String>();
		TreeSet<String> r = new TreeSet<String>();
		Permutation(str.toCharArray(), 0, r);
		result.addAll(r);
		return result;
	}

	public void Permutation(char[] str, int i, TreeSet<String> result) {
		if (i == str.length - 1) {
			result.add(String.valueOf(str));
		} else {
			for (int j = i; j < str.length; j++) {
				// 与自己交换会产生重复的情况
				swap(str, i, j);
				Permutation(str, i + 1, result);
				swap(str, i, j);
			}
		}
	}

	private void swap(char[] str, int i, int j) {
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
	}
}
