package 牛客616;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 * @author tigerto
 *
 */
public class Main11 {
	/**
	 * 简单快速幂
	 */
	public double power(double base, int exponent) {
		double res = 1;
		int n = Math.abs(exponent);
		while (n != 0) {
			if ((n & 1) != 0) {
				res *= base;
			}
			base *= base;
			n >>= 1;
		}
		return exponent < 0 ? 1 / res : res;
	}
}
