package 牛客616;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * @author Chan
 *
 */
public class Main52___ {
	public int[] multiply(int[] A) {
		int[] B = new int[A.length];
		B[0] = 1;
		for (int i = 1; i < A.length; i++) {
			B[i] = A[i - 1] * B[i - 1];
		}

		int c = 1;
		for (int i = A.length - 2; i >= 0; i--) {
			c *= A[i+1];
			B[i] *= c;
		}
		return B;
	}
}
