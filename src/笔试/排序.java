package 笔试;

public class 排序 {

	public static void main(String[] args) {
		int[] a = new int[50];
		for (int i = 0; i < 10; i++) {
			a[i] = (int) (Math.random() * 100);
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		heapSort(a, 10);
		for (int i = 0; i < 10; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}

	//插入排序
	public static void insertSort(int[] array, int length) {
		int i, j, tmp;
		for (i = 1; i < length; i++) {
			if (array[i - 1] > array[i]) {
				tmp = array[i];
				for (j = i - 1; j >= 0 && array[j] > tmp; j--) {
					array[j + 1] = array[j];
				}
				array[j + 1] = tmp;
			}
		}
	}

	//二分插入排序
	public static void bInsertSort(int[] array, int length) {
		int low, middle, high, i, j, tmp;
		for (i = 1; i < length; i++) {
			tmp = array[i];
			low = 0;
			high = i - 1;
			while (low <= high) {
				middle = (low + high) / 2;
				if (array[middle] < tmp) {
					low = middle + 1;
				} else {
					high = middle - 1;
				}
			}

			for (j = i; j > low; j--) {
				array[j] = array[j - 1];
			}
			array[low] = tmp;
		}
	}

	//希尔排序
	public static void shellSort(int[] array, int length) {
		int gap, tmp, i, j;
		for (gap = length / 2; gap > 0; gap /= 2) {
			for (i = gap; i < length; i++) {
				if (array[i - gap] > array[i]) {
					tmp = array[i];
					for (j = i - gap; j >= 0 && array[j + gap] < array[j]; j -= gap) {
						array[j + gap] = array[j];
					}
					array[j + gap] = tmp;
				}
			}
		}
	}

	//冒泡排序
	public static void bubbleSort(int[] array, int length) {
		int i, j, tmp;
		for (i = 0; i < length - 1; i++) {
			for (j = 1; j < length - i; j++) {
				if (array[j - 1] > array[j]) {
					tmp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

	//快速排序
	public static void quickSort(int[] array, int length) {
		quickSort(array, 0, length - 1);
	}

	private static int partition(int[] array, int low, int high) {
		int pivotkey = array[low];
		while (low < high) {
			while (low < high && pivotkey <= array[high]) {
				high--;
			}
			array[low] = array[high];
			while (low < high && pivotkey >= array[low]) {
				low++;
			}
			array[high] = array[low];
		}
		array[low] = pivotkey;
		return low;
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivotLoc = partition(array, low, high);
			quickSort(array, low, pivotLoc - 1);
			quickSort(array, pivotLoc + 1, high);
		}
	}

	//选择排序
	public static void selectSort(int[] array, int length) {
		int i, j, tmp, minLoc;
		for (i = 0; i < length; i++) {
			minLoc = i;
			for (j = i + 1; j < length; j++) {
				if (array[minLoc] > array[j]) {
					minLoc = j;
				}
			}
			if (minLoc != i) {
				tmp = array[i];
				array[i] = array[minLoc];
				array[minLoc] = tmp;
			}
		}
	}

	//堆排序
	public static void heapSort(int[] array, int length) {
		for (int i = length / 2; i > 0; i--) {
			headAdjust(array, i, length);
		}

		for (int i = length; i > 0; i--) {
			int tmp = array[0];
			array[0] = array[i - 1];
			array[i - 1] = tmp;

			headAdjust(array, 1, i - 1);
		}
	}

	// 从下标零开始，所以都减去1. 大根堆
	private static void headAdjust(int[] array, int s, int length) {
		int tmp = array[s - 1];
		for (int i = s * 2; i <= length; i *= 2) {
			if (i < length && array[i - 1] < array[i]) {
				i++;
			}

			if (array[i - 1] < tmp) {
				break;
			}

			array[s - 1] = array[i - 1];
			s = i;
		}
		array[s - 1] = tmp;
	}

	//归并排序
	public static void merge(int[] array, int low, int middle, int high) {
		int i = 0, tmp = low;
		int[] tmpArray = new int[high - low + 1];
		while (low <= middle && middle <= high) {
			if (array[low] < array[middle + 1]) {
				tmpArray[i++] = array[low++];
			} else {
				tmpArray[i++] = array[++middle];
			}
		}
		
		while(low<=middle){
			tmpArray[i++]=array[middle++];
		}
		
		while(middle<=high){
			tmpArray[i++]=array[++middle];
		}
	}
}
