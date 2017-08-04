package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 组合 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] nums = new int[n];
			for(int i=0; i<n; i++){
				nums[i] = in.nextInt();
			}
			
			int count = 0;
			int[] result = new int[(1<<n) - 1];
			
			for(int i=1; i< 1<<n; i++){
				int sum = 0;
				boolean flag = false;
				for(int j=0; j<n; j++){
					if((i & (1<<j)) != 0){
						sum = sum*10 + nums[j];
						flag = true;
					}
				}
				if(flag){
					result[count++] = sum;
				}
			}
			Arrays.sort(result);
			for(int i:result){
				System.out.print(i+" ");
			}
			
		}
		in.close();
	}

}
