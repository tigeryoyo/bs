package 小米;

/**
 * 归并排序
 * 条件一：不能用递归 
 * 条件二：自底向上（不好意思...刚才想成了快速排序从最后一个为指针开始排。。）
 * @author Chan
 *
 */
public class xiaomi_2 {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		mergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		int n = arr.length, x = 1;
		for (int i = 1; (1 << i) < n; i++) {
			int p = 1 << i;
			x = p;
			for (int j = 0; j < n; j += p)
				if (j + (p >> 1) < n) {
					mergePass(arr, tmp, j, Math.min(n, j + p), j + (p >> 1));
				}
		}
		mergePass(arr, tmp, 0, arr.length, x);
	}

	static void mergePass(int[] arr, int[] tmp, int l, int r, int mid) {
		int x = l, y = mid, p = l ;
		while (x < mid || y < r) {
			if (x == mid || (y < r && arr[x] > arr[y])) {
				tmp[p++] = arr[y++];
			} else {
				tmp[p++] = arr[x++];
			}
		}
		for (int i = l; i < r; i++) {
			arr[i] = tmp[i];
		}
	}

}
