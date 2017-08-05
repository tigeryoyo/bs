package 牛客616;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 在该栈中，调用min、push及pop的时间复杂度都是O（1）
 * 
 * @author tigerto
 *
 */
public class Main21___ {
	Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> assi = new Stack<Integer>();

	public static void main(String[] args) {
		Main21___ m = new Main21___();
		m.push(3);
		System.out.println(m.min());
		m.push(4);
		System.out.println(m.min());
		m.push(2);
		System.out.println(m.min());
		m.push(3);
		System.out.println(m.min());
		m.pop();
		System.out.println(m.min());
		m.pop();
		System.out.println(m.min());
		m.pop();
		System.out.println(m.min());
		m.push(0);
		System.out.println(m.min());
	}

	public void push(int node) {
		data.push(node);
		if (!assi.isEmpty()) {
			int min = assi.peek();
			if (node < min) {
				assi.push(node);
			} else {
				assi.push(min);
			}
		} else {
			assi.push(node);
		}
	}

	public void pop() {
		data.pop();
		assi.pop();
	}

	public int top() {
		return data.peek();
	}

	public int min() {
		return assi.peek();
	}
}
