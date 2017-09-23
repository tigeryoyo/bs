package leetcode;

import java.util.*;

public class Main {
	static String helper(String data) {
		String[] arr = data.split(":");
		if (arr.length < 2) {
			return data;
		}
		StringBuilder sb = new StringBuilder();
		int len = data.length();
		int index = data.indexOf("\"") + 1;
		for (int i = 0; i < len; i++) {
			char c = data.charAt(i);
			if (i == index) {
				if (c <= 'z' && c >= 'a') {
					c = (char) (c - 'a' + 'A');
				}
			}
			sb.append(c + "");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.close();
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = gas.length - 1;
		int end = 0;
		int total = gas[start] - cost[start];
		while (end < start) {
			if (total >= 0) {
				total += gas[end] - cost[end];
				end++;
			} else {
				start--;
				total += gas[start] - cost[start];
			}
		}
		return total >= 0 ? start : -1;
	}
}
