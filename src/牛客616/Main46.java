package 牛客616;

/**
 * 1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断句（A？B：C）
 * 
 * @author tigerto
 *
 */
public class Main46 {
	public int Sum_Solution(int n) {
		int sum = n;
		boolean r = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
		return sum;
	}
}
