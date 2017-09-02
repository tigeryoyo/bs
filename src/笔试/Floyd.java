package 笔试;

public class Floyd {

	public static void main(String[] args) {

	}

	/**
	 * floyed算法：求图中任意两点的最短距离
	 * 
	 * @param vertex
	 *            邻接矩阵存储图
	 * @param prePath
	 *            顶点i到顶点j的前驱路径
	 * @return
	 */
	int[][] floyed(int[][] vertex, int[][] prePath) {
		int[][] ans = new int[vertex.length][vertex.length];
		for (int i = 0; i < vertex.length; i++) {
			for (int j = 0; j < vertex.length; j++) {
				ans[i][j] = vertex[i][j];
				prePath[i][j] = -1;
			}
		}

		for (int k = 0; k < vertex.length; k++) {
			for (int i = 0; i < vertex.length; i++) {
				for (int j = 0; j < vertex.length; j++) {
					if (ans[i][j] > vertex[i][k] + vertex[k][j]) {
						ans[i][j] = vertex[i][k] + vertex[k][j];
						prePath[i][j] = k;
					}
				}
			}
		}
		return ans;
	}

}
