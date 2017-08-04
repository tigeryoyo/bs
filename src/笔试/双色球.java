package 笔试;

import java.util.Arrays;
import java.util.Scanner;

//红色球号码区由1-33共三十三个号码组成，蓝色球号码区由1-16共十六个号码组成

public class 双色球 {

	public final static int RMAX = 33;
	public final static int BMAX = 16;

	public static void main(String[] args) {
		int[] redArr = new int[RMAX];
		for (int i = 0; i < RMAX; i++) {
			redArr[i] = i + 1;
		}
		int[] blueArr = new int[BMAX];
		for (int i = 0; i < BMAX; i++) {
			blueArr[i] = i + 1;
		}
		Scanner in = new Scanner(System.in);
		System.out.print("Please type the number of times: ");
		while (in.hasNext()) {
			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				System.out.print("第" + (i + 1) + "次：");
				int[] bRes = new int[6];
				for (int j = 0; j < 6; j++) {
					int random = (int) (Math.random() * (RMAX - j));
					bRes[j] = redArr[random];
					int tmp = redArr[RMAX - j - 1];
					redArr[RMAX - j - 1] = redArr[random];
					redArr[random] = tmp;
				}
				Arrays.sort(bRes);
				for (int j : bRes) {
					System.out.print("\t" + j);
				}

				int random = (int) (Math.random() * (BMAX));
				System.out.println("\t" + blueArr[random]);
			}
			System.out.print("Please type the number of times: ");
		}
		in.close();
	}
}
