package 牛客616;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 
 * @author Chan
 *
 */
public class Main35 {

	public int FirstNotRepeatingChar(String str) {
		int[] cs = new int['z' + 1];
		for (int i = 0; i < str.length(); i++) {
			int c = (int) str.charAt(i);
			cs[c]++;
		}

		int index = -1;
		for (int i = 0; i < str.length(); i++) {
			if (cs[(int) str.charAt(i)] == 1) {
				index = i;
				break;
			}
		}

		return index;
	}
}
