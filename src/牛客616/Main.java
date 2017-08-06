package 牛客616;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void init(int[] nums, int n) {
		nums[0] = 1;
		for (int i = 1; i <= n; i++) {
			nums[i] = nums[i - 1] << 1 % 1000000007;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] po = new int[100001];
		init(po, 100000);
		while (in.hasNext()) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = in.nextInt();
			}
			Arrays.sort(nums);
			int r = 0;
			int a = 0;
			int b = n - 1;
			while (a <= b) {
				if (nums[a] + nums[b] <= k) {
					r += po[b - a];
					a++;
				} else {
					b--;
				}
			}
			System.out.println(r % 1000000007);
		}
		in.close();
	}
}
