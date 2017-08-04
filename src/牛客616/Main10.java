package 牛客616;

import java.util.Scanner;

public class Main10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int c = 0;
			int f = 1;
			while (f != 0) {
				if ((n & f) != 0) {
					c++;
				}
				f = f << 1;
			}
			System.out.println(c);
		}
		in.close();
	}

}
