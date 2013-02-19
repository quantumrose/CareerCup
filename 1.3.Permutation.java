// Cracking the Coding Interview 1.3
// Given two strings, write a method to decide if one is a permutation of the other.

// permutation: case sensitive / whitespace significant

public class Permutation {
	// method1: sort strings and compare
	// O(nlogn) time, O(logn) space
	public static boolean permutation1(String str1, String str2) {
		// optimization: two strings with different lengths cannot be anagrams
		if (str1.length() != str2.length()) {
			return false;
		}

		return sort(str1).equals(sort(str2));
	}

	public static String sort(String str) {
		char[] array = str.toCharArray();

		quickSort(array, 0, array.length - 1);

		return new String(array);
	}

	public static void quickSort(char[] array, int left, int right) {
		if (left < right) {
			int pivotIndex = (left + right) / 2;

			int pivotNewIndex = partition(array, left, right, pivotIndex);

			quickSort(array, left, pivotNewIndex - 1);
			quickSort(array, pivotNewIndex + 1, right);
		}
	}

	public static int partition(char[] array, int left, int right, int pivotIndex) {
		char pivotValue = array[pivotIndex];

		swap(array, right, pivotIndex);

		int storeIndex = left;

		for (int i = left; i < right; i++) {
			if (array[i] < pivotValue) {
				swap(array, i, storeIndex);
				storeIndex += 1;
			}
		}
		swap(array, storeIndex, right);

		return storeIndex;
	}

	public static void swap(char[] array, int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	// method2: compare character counts
	// O(n) time, O(1) space
	public static boolean permutation2(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		int[] counts = new int[256];

		for (int i = 0; i < str1.length(); i++) {
			int val = str1.charAt(i);
			counts[val] += 1;
		}

		for (int i = 0; i < str2.length(); i++) {
			int val = str2.charAt(i);
			counts[val] -= 1;

			if (counts[val] < 0) {
				return false;
			}
		}
		return true;
	}
}
