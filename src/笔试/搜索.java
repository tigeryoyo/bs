package 笔试;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 5行4列,打印从A点(0,0)到B点(3,2)的最短路径
 */
public class 搜索 {

	final static int row = 5;
	final static int col = 4;

	public static void main(String[] args) {
		int[][] map = new int[row][col];
		map[0][2] = 1;
		map[2][2] = 1;
		map[3][1] = 1;
		map[4][3] = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		Node a = new Node(0, 0);
		Node b = new Node(3, 2);
		bfs(map, a, b);
	}

	// 广度优先搜索
	public static void bfs(int[][] map, Node a, Node b) {
		Queue<Node> queue = new LinkedList<Node>();
		boolean[][] flag = new boolean[row][col];
		flag[0][2] = true;
		flag[2][2] = true;
		flag[3][1] = true;
		flag[4][3] = true;
		queue.add(a);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.equals(b)) {
				Node tmp = cur;
				do {
					System.out.println(tmp.x + "," + tmp.y);
					tmp = tmp.pre;
				} while (tmp != null);
				System.out.println();
			}
			if (cur.x - 1 >= 0 && !flag[cur.x - 1][cur.y]) {
				flag[cur.x - 1][cur.y] = true;
				Node node = new Node(cur.x - 1, cur.y);
				node.pre = cur;
				queue.add(node);
			}
			if (cur.x + 1 <= row - 1 && !flag[cur.x + 1][cur.y]) {
				flag[cur.x + 1][cur.y] = true;
				Node node = new Node(cur.x + 1, cur.y);
				node.pre = cur;
				queue.add(node);
			}
			if (cur.y - 1 >= 0 && !flag[cur.x][cur.y - 1]) {
				flag[cur.x][cur.y - 1] = true;
				Node node = new Node(cur.x, cur.y - 1);
				node.pre = cur;
				queue.add(node);
			}
			if (cur.y + 1 <= col - 1 && !flag[cur.x][cur.y + 1]) {
				flag[cur.x][cur.y + 1] = true;
				Node node = new Node(cur.x, cur.y + 1);
				node.pre = cur;
				queue.add(node);
			}
		}
	}

	static class Node {
		int x, y;
		Node pre;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			pre = null;
		}

		@Override
		public boolean equals(Object object) {
			Node node = (Node) object;
			return node.x == this.x && node.y == this.y;
		}
	}
}
