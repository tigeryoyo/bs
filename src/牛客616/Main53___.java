package 牛客616;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 * @author Chan
 *
 */
public class Main53___ {

	// "",".*"

	public static void main(String[] args) {
		char[] str = "123".toCharArray();
		char[] pattern = "123.*".toCharArray();
		System.out.println(new Main53___().match(str, pattern));
	}

	public boolean match(char[] str, char[] pattern) {
		return match(str, 0, pattern, 0);
	}

	// 分三种情况
	// 1.(相应位匹配 || (pattern[p_i]为. && str[s_i]未溢出)) && pattern[p_i+1]为*
	// 2.(相应位匹配 || (pattern[p_i]为. && str[s_i]未溢出)) && pattern[p_i+1]不为*
	// 3.相应位不匹配&& (pattern[p_i]不为. || str[s_i]溢出)

	// 对应1，最复杂。分为*取0，*取1，*>=2三种情况。
	// 取0对应跳过当前匹配位，继续寻找patter的下一个匹配位，str不变，pattern+2
	// 取1对应当前匹配位算一次成功匹配，str+1，pattern+2
	// 取>=2对应一次成功匹配，继续匹配字符串的下一位是否匹配，str+1，pattern不变
	// 三者取或。即只要有一种情况能匹配成功认为字符串就是匹配成功的。
	public boolean match(char[] str, int s_i, char[] pattern, int p_i) {
		if (s_i == str.length && p_i == pattern.length) {
			return true;
		}
		if (s_i != str.length && p_i == pattern.length) {
			return false;
		}
		if (p_i + 1 < pattern.length && pattern[p_i + 1] == '*') {
			if (s_i != str.length && (str[s_i] == pattern[p_i] || pattern[p_i] == '.')) {
				return match(str, s_i, pattern, p_i + 2) || match(str, s_i + 1, pattern, p_i + 2) || match(str, s_i + 1, pattern, p_i);
			} else { // aa与b*aa
				return match(str, s_i, pattern, p_i + 2);
			}
		}
		if (s_i != str.length && (str[s_i] == pattern[p_i] || pattern[p_i] == '.')) {
			return match(str, s_i + 1, pattern, p_i + 1);
		}
		return false;
	}
}
