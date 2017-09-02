package 笔试;

import java.util.Arrays;

public class Dijkstra {
	/**
	 * dijkstra算法：求图中某点到其他点的最短距离
	 * 
	 * @param vertex
	 *            邻接矩阵存储图
	 * @param v
	 *            顶点v
	 * @param path
	 *            顶点v到其他顶点的前驱路径
	 * @return
	 */
	int[] dijkstra(int[][] vertex, int v, int[] path) {
		int[] dist = new int[vertex.length];
		for (int i = 0; i < vertex.length; i++) {
			dist[i] = vertex[v][i];
			path[i] = -1;
		}
		boolean[] s = new boolean[vertex.length];
		Arrays.fill(s, false);
		s[v] = true;
		for (int i = 0; i < vertex.length; i++) {
			int mindist = Integer.MAX_VALUE;
			int minv = -1;
			for (int j = 0; j < vertex.length; j++) {
				if (!s[j] && mindist > dist[j]) {
					mindist = j;
					minv = j;
				}
			}
			s[minv] = true;
			dist[minv] = mindist;
			for (int j = 0; j < vertex.length; j++) {
				if (!s[j] && dist[j] > dist[minv] + vertex[minv][j]) {
					dist[j] = dist[minv] + vertex[minv][j];
					path[j] = minv;
				}
			}
		}
		return dist;
	}
}
