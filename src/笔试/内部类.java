package 笔试;

public class 内部类 {

	final int m = 1;
	static int n = 2;
	private int mn = 3;

	public void fun() {
		A a = new A() {

			@Override
			public void dosometing() {
				// TODO Auto-generated method stub
				System.out.println(mn);
			}
		};
		a.dosometing();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 内部类().fun();
		A a = new A() {

			@Override
			public void dosometing() {
				// TODO Auto-generated method stub
				System.out.println(n);
			}
		};
	}

}

interface A {
	public void dosometing();
}
