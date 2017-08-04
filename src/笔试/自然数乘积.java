package 笔试;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class 自然数乘积 {
	public static long solve(int n,long[][] dp){
		long ans = 0;
		for(int i = 0; i <= n; i++)
			ans = Math.max(ans, dp[n][i]);
		return ans;
	}

	public static void main(String[] args) {
		int[] a = new int[2];
		
		try {
			new BufferedWriter(new FileWriter("a.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			long[][] dp = new long[n+1][n+1];
			for (int i = 0; i <= n; i++)
				dp[0][i] = 1;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					for (int k = 0; k < j; k++)
						dp[i][j] = Math.max(dp[i][j], dp[i - j][k] * j);
				}
			}
			System.out.println(solve(n,dp));
		}
		in.close();
	}
}
