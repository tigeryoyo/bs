package 笔试;

import java.util.Scanner;

/**
 * 最大公倍数*最大公约数=两数的乘积
 * 
 * @author Chan
 *
 */
public class 最大公约数 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int m = in.nextInt();
			int n = in.nextInt();
			if (m < n) {
				int t = m;
				m = n;
				n = t;
			}

			while (m % n != 0) {
				int c = m % n;
				m = n;
				n = c;
			}
			System.out.println(n);
		}
		in.close();
	}
}