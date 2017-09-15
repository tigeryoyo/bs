package leetcode;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * For example, given s ="leetcode", dict =["leet", "code"]. Return true
 * because"leetcode"can be segmented as"leet code".
 * 
 * @author tigerto
 *
 */
public class word_break_i {

	public boolean wordBreak(String s, Set<String> dict) {
		if (dict == null || dict.size() == 0) {
			return false;
		}
		int len = s.length();
		// dp[i]表示字符串s的0~i-1为的分割情况
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = i - 1; j >= 0; j--) {
				String cur = s.substring(j, i);
				if (dp[j] && dict.contains(cur)) {
					dp[i] = true;
				}
			}
		}
		return dp[len];
	}
}
