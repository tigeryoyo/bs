package 牛客616;

import java.util.Scanner;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author tigerto
 *
 */
public class Main09 {

	/**
	 * 每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int a = 1;
			int b = 2;
			int c = 0;
			for (int i = 2; i < n; i++) {
				c = a + b;
				a = b;
				b = c;
			}
			if (n == 1) {
				c = 1;
			}
			if (n == 2) {
				c = 2;
			}
			System.out.println(c);
		}
		in.close();
	}

}
