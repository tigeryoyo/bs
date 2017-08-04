package 牛客616;

import java.util.Scanner;

public class Main09 {

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
