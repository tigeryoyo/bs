package 牛客616;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}

			Arrays.sort(arr);

			int max = 0;
			List<Integer> res = new ArrayList<Integer>();
			res.add(arr[0]);
			boolean lSet = true;
			for (int i = 1; i < n; i++) {
				int curMax = 0;
				if (lSet) {
					res.add(0, arr[i]);
					curMax = Math.abs(res.get(1) - arr[i]);
				} else {
					res.add(arr[i]);
					curMax = Math.abs(res.get(i - 1) - arr[i]);
				}
				lSet = !lSet;
				if (curMax > max) {
					max = curMax;
				}
			}

			System.out.println(max);
		}
		in.close();
	}

}
