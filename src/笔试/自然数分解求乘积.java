package 笔试;

import java.util.Scanner;

public class 自然数分解求乘积 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			long sum = 1;
			int k = (int) Math.sqrt(n * 2);

			k = k - 3;
			if (k <= 1)
				k = 2;
			while ((2 + k) * (k - 1) / 2 <= n)
				k += 1;
			// printf("%d\n", k);
			k--;
			int j = n - (2 + k) * (k - 1) / 2;

			for (int i = 2; i <= k - j; i++)
				sum *= i;
			for (int i = k - j + 2; i <= k + 1; i++)
				sum *= i;
			System.out.println(sum);
		}
		in.close();
	}
}
