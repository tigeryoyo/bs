package 牛客616;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * 
 * 利用归并排序的思想。
 * 
 * @author Chan
 *
 */
public class Main36___ {
	private int count = 0;

	public int InversePairs(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		mergesort(array, 0, array.length - 1);
		return count;
	}

	private void mergesort(int[] array, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergesort(array, start, mid);
			mergesort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}

	private void merge(int[] array, int start, int mid, int end) {
		int[] tmp = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;
		while (i <= mid && j <= end) {
			if (array[i] <= array[j]) {
				tmp[k++] = array[i++];
			} else {
				tmp[k++] = array[j++];
				count += mid - i + 1;
				count %= 1000000007;
			}
		}

		while (i <= mid) {
			tmp[k++] = array[i++];
		}
		while (j <= end) {
			tmp[k++] = array[j++];
		}

		for (i = 0; i < k; i++) {
			array[start + i] = tmp[i];
		}
	}
}
