// Cracking the Coding Interview 1.8
// Assume you have a method isSubstring which checks if one word is a substring of another.
// Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").

public class IsRotation {
	// rotation: (1) same length (2) s1s1 contains s2
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		String s1s1 = s1 + s1;

		if (isSubstring(s1s1, s2)) {
			return true;
		}
		return false;
	}

	public static boolean isSubstring(String s1, String s2) {
		if (s1.contains(s2)) {
			return true;
		}
		else {
			return false;
		}
	}
}
