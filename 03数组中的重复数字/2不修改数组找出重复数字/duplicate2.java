public class Duplicate2 {
	public static int findDuplicate(int[] arr) {
		// 数组非空
		if (arr.length == 0){
			return -1;
		}

		// 数字在合理1～n内，数组长度为n+1
		for (int i : arr) {
			if (i < 1 || i >arr.length - 1) {
				return -1;
			}
		}

		int start = 1;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int count = countRange(arr, start, mid);
			// 终止条件
			if (start == end) {
				if (count > 1) {
					return mid;
				} else {
					return -1;
				}
			}
			if(count > (mid - start + 1)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static int countRange(int[] arr, int start, int end) {
		if (arr.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i : arr) {
			if (i >= start && i <= end) {
				count += 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
		int duplicate = findDuplicate(arr);
		System.out.println(duplicate);
	}
}