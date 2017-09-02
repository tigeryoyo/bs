package 牛客616;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			long[] presum = new long[100001];
			for (int i = 1; i <= n; i++) {
				presum[i] = presum[i - 1] + in.nextInt();
			}
			int k = in.nextInt();

			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j <= n; j++) {
					if (max >= n - i) {
						break;
					}
					if (j - i > max && (presum[j] - presum[i]) % k == 0) {
						max = j - i;
					}
				}
			}
			System.out.println(max);
		}
		in.close();
	}
}