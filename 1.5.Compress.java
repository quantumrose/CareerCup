// Cracking the Coding Interview 1.5
// Implement a method to perform basic string compression using the counts of repeated characters.
// For example, the string aabcccccaaa would become a2b1c5a3.
// If the "compressed" string would not become smaller than the original string, your method should return the original string.

// simple string concatenation operates in O(n^2) time, use StringBuilder or char array

public class Compress {
	// method1: StringBuilder
	// StringBuffer vs StringBuilder: StringBuffer is synchronized, which makes it thread-safe but slow
	// O(n) time
	public static String compress1(String str) {
		if (str == null || compressedLength(str) >= str.length()) {
			return str;
		}

		StringBuilder builder = new StringBuilder();
		char current = str.charAt(0);
		int cnt = 1;

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != current) {
				builder.append(current + Integer.toString(cnt));
				current = str.charAt(i);
				cnt = 1;
			}
			else {
				cnt += 1;
			}
		}
		builder.append(current + Integer.toString(cnt));

		return builder.toString();
	}

	// method2: char array
	// O(n) time
	public static String compress2(String str) {
		if (str == null) {
			return str;
		}

		int length = compressedLength(str);
		if (length >= str.length()) {
			return str;
		}

		char[] buffer = new char[length];
		char current = str.charAt(0);
		int index = 0, cnt = 1;

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != current) {
				buffer[index++] = current;
				for (int j = 0; j < Integer.toString(cnt).length(); j++) {
					buffer[index++] = Integer.toString(cnt).charAt(j);
				}
				current = str.charAt(i);
				cnt = 1;
			}
			else {
				cnt += 1;
			}
		}
		buffer[index++] = current;
		for (int j = Integer.toString(cnt).length()- 1; j >= 0; j--) {
			buffer[index++] = Integer.toString(cnt).charAt(j);
		}

		return new String(buffer);
	}

	public static int compressedLength(String str) {
		if (str == null) {
			return 0;
		}

		char current = str.charAt(0);
		int length = 0, cnt = 1;

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != current) {
				length += 1 + Integer.toString(cnt).length();
				current = str.charAt(i);
				cnt = 1;
			}
			else {
				cnt += 1;
			}
		}
		length += 1 + Integer.toString(cnt).length();

		return length;
	}
}
