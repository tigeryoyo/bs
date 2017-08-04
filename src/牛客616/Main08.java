package 牛客616;

public class Main08 {
	public int minNumberInRotateArray(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int low = 0;
		int high = array.length - 1;
		int mid = low;
		while (array[low] >= array[high]) {
			if (array[low] == array[high]) {
				for (int i = low; i < array.length; i++) {
					if (array[low] != array[i]) {
						low = i - 1;
						break;
					}
				}
				for (int i = high; i >= 0; i--) {
					if (array[high] != array[i]) {
						high = i + 1;
						break;
					}
				}
			}
			if (high - low <= 1) {
				mid = high;
				break;
			}
			mid = (low + high) / 2;
			if (array[mid] >= array[low]) {
				low = mid;
			} else if (array[mid] <= array[high]) {
				high = mid;
			}
		}
		return array[mid];
	}
}