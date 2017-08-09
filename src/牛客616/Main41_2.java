package 牛客616;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * 
 * @author Chan
 *
 */
public class Main41_2 {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> i = new Main41_2().FindContinuousSequence(9);
		System.out.println(i);
	}

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> cur = new ArrayList<Integer>();
		if (sum <= 1) {
			return res;
		}
		int i = 0;
		int max = sum / 2 + 1;
		int csum = 0;
		while (i <= max) {
			if (csum < sum) {
				i++;
				cur.add(i);
				csum += i;
			} else if (csum > sum) {
				csum -= cur.remove(0);
			} else {
				res.add(new ArrayList<Integer>(cur));
				csum -= cur.remove(0);
				i++;
				cur.add(i);
				csum += i;
			}
		}
		return res;
	}
}
