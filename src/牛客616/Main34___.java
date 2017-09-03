package 牛客616;

import java.util.ArrayList;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * @author Chan
 *
 */
public class Main34___ {
	public int GetUglyNumber_Solution(int index) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (res.size() < index) {
			int n2 = res.get(i2) * 2;
			int n3 = res.get(i3) * 3;
			int n5 = res.get(i5) * 5;
			int min = Math.min(n2, Math.min(n3, n5));
			res.add(min);
			if (min == n2)
				i2++;
			if (min == n3)
				i3++;
			if (min == n5)
				i5++;
		}
		return index <= 0 ? 0 : res.get(index - 1);
	}
}
