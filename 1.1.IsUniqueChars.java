// Cracking the Coding Interview 1.1
// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

// string: ASCII or Unicode

public class IsUniqueChars {
	// method 1: use boolean array
	// O(n) time, 0(1) space
	public static boolean isUniqueChars1(String str) {
		// optimization: return FALSE if string length > number of unique characters in alphabet
		if (str.length() > 256) {
			return false;
		}

		boolean[] flags = new boolean[256]; // default value of boolean is FALSE

		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);

			if (flags[val]) {
				return false;
			}
			flags[val] = true;
		}
		return true;
	}

	// method 2: use bit vector
	// boolean array uses 1 byte per element, bit vector reduces space usage by a factor of eight
	// O(n) time, O(1) space
	public static boolean isUniqueChars2(String str) {
		if (str.length() > 256) {
			return false;
		}

		byte[] bitVector = new byte[256 / 8]; // default value of byte is 0

		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);

			if ((bitVector[val / 8] & 1 << val % 8) != 0) {
				return false;
			}
			bitVector[val / 8] |= 1 << val % 8;
		}
		return true;
	}

	// method 3: compare every character to every other character
	// no additional data structures
	// O(n^2) time, O(1) space
	public static boolean isUniqueChars3(String str) {
		if (str.length() > 256) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
