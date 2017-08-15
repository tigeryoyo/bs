package 牛客616;

/**
 * 不用+、-、*、/、做加法
 * 
 * @author tigerto
 *
 */
public class Main47___ {

	public static void main(String[] args) {
		System.out.println(new Main47___().Add(11, 2));
	}

	public int Add(int num1, int num2) {
		int sum, carray;
		do {
			sum = num1 ^ num2;
			carray = (num1 & num2) << 1;
			num1 = sum;
			num2 = carray;
		} while (num2 != 0);
		return sum;
	}
}
