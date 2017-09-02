package 笔试;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();

        int max = 0;
        int nowN = n;
        int nowM = m;

        for(int i=0;i<=n/d;i++) {
            nowN = n - (d * i);
            for(int j=0;j<=m/c;j++) {
                nowM = m - (c * j);
                int price = (z * i) + (y * j) + (Math.min(nowM/b, nowN/a) * x);
                if(price > max) {
                    max = price;
                }
            }
        }
        System.out.println(max);
    }
}