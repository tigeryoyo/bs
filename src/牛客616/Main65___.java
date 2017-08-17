package 牛客616;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * 
 * @author Chan
 *
 */
public class Main65___ {

	public static void main(String[] args) {
		ArrayList<Integer> res = new Main65___().maxInWindows(new int[] { 2, 3, 4, 2, 6, 2, 5, 1 }, 3);
		System.out.println(res);
	}

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Deque<Integer> queue = new LinkedList<Integer>();
		if (size <= 0) {
			return res;
		}
		for (int i = 0; i < num.length; i++) {
			//从后面依次弹出队列中比当前num值小的元素，同时也能保证队列首元素为当前窗口最大值下标
			while (!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
				queue.pollLast();
			}
			//当当前窗口移出队首元素所在的位置，即队首元素坐标对应的num不在窗口中，需要弹出
			while (!queue.isEmpty() && i - queue.peekFirst() + 1 > size) {
				queue.pollFirst();
			}
			//把每次滑动的num下标加入队列
			queue.offer(i);
			//当滑动窗口首地址i大于等于size时才开始写入窗口最大值
			if (i + 1 >= size) {
				res.add(num[queue.peekFirst()]);
			}
		}

		return res;
	}
}
