package 牛客616;

import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int k = in.nextInt();
			int c = 0;

			int most = 0;
			int t = n - 1;
			for (int i = 0; i < k; i++) {
				most += t;
				t--;
			}

			for (int i = n; i <= most; i += n) {
				int[] res = new int[k];
			}

			System.out.println(c % 1000000007);
		}
		in.close();
	}

	public static int getCount(int start, int n, int k, int sum) {
		
		
		return 0;
	}

}
