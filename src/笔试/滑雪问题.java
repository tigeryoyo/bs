package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 滑雪问题 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int row = in.nextInt();
			int col = in.nextInt();
			int[][] nums = new int[row][col];
			HNode[] nodes = new HNode[row * col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					nodes[i * row + j] = new HNode();
					nums[i][j] = in.nextInt();
					nodes[i * row + j].row = i;
					nodes[i * row + j].col = j;
					nodes[i * row + j].height = nums[i][j];
				}
			}

			Arrays.sort(nodes);
			int[][] pos = new int[row][col];
			for(int i=0; i<nodes.length; i++){
				pos[nodes[i].row][nodes[i].col] = i;
			}

			for (int i = 0; i < row * col; i++) {
				int max = nodes[i].len;
				int crow = nodes[i].row;
				int ccol = nodes[i].col;
				int lcol = ccol - 1;
				int rcol = ccol + 1;
				int urow = crow - 1;
				int drow = crow + 1;
				if (lcol >= 0 && nums[crow][lcol] < nodes[i].height) {
					if (max <= nodes[pos[crow][lcol]].len) {
						max = nodes[pos[crow][lcol]].len + 1;
					}
				}
				if (rcol < col && nums[crow][rcol] < nodes[i].height) {
					if (max <= nodes[pos[crow][rcol]].len) {
						max = nodes[pos[crow][rcol]].len + 1;
					}
				}
				if (urow >= 0 && nums[urow][ccol] < nodes[i].height) {
					if (max <= nodes[pos[urow][ccol]].len) {
						max = nodes[pos[urow][ccol]].len + 1;
					}
				}
				if (drow < row && nums[drow][ccol] < nodes[i].height) {
					if (max <= nodes[pos[drow][ccol]].len) {
						max = nodes[pos[drow][ccol]].len + 1;
					}
				}
				nodes[i].len = max;
			}
			int maxLen = 0;
			for (int i = 0; i < row * col; i++) {
				if (nodes[i].len > maxLen) {
					maxLen = nodes[i].len;
				}
			}
			System.out.println(maxLen);
		}
		in.close();
	}
}

class HNode implements Comparable {
	int row;
	int col;
	int height;
	// 记录当前高度的路径长度
	int len = 1;

	@Override
	public int compareTo(Object o) {
		return this.height - ((HNode) o).height;
	}
}
