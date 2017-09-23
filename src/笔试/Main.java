package 笔试;

import java.util.*;

public class Main{

	public static void main(String[] args) {
		double a = 100;
		System.out.println(a/2);
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] l = new int[n + 1];
		int[][] s = new int[11][7];
		int[][] r = new int[11][7];
		int[][] m = new int[n + 1][12];
		
		for (int i = 0; i < 11; i ++) {
			Arrays.fill(s[i], 0);
			Arrays.fill(r[i], 0);
		}
		
		for (int i = 1; i <= n; i ++) {
			int x = sc.nextInt();
			int y = x;
			
			l[i] = 0;
			while(x > 0) { l[i] ++; x /= 10; }
			r[l[i]][y % 7] ++;
			
			m[i][0] = y % 7;
			for (int j = 0; j <= 10; j ++) {
				s[j][m[i][j]] ++;
				m[i][j + 1] = m[i][j] * 3 % 7;
			}
		}
		
		long ans = 0;
		for (int i = 1; i <= n; i ++) {
			ans += s[l[i]][(7 - m[i][0]) % 7];
			if((m[i][l[i]] + m[i][0]) % 7 == 0) ans --;
			
			for (int j = 1; j <= 10; j ++) {
				int need = (7 - m[i][j]) % 7;
				ans += r[1][need];
				if(l[i] == j && m[i][0] == need) {
					ans --;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}