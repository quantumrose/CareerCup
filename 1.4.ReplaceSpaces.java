// Cracking the Coding Interview 1.4
// Write a method to replace all spaces in a string with '%20'.
// You may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string.
// (Note: if implementing in Java, please use a character array so you can perform this operation in place.)
//
// EXAMPLE
// Input : "Mr John Smith    "
// Output: "Mr%20John%20Smith"

// string manipulation: edit from the end and work backwards

public class ReplaceSpaces {
	public static void replaceSpaces(char[] str, int length) {
		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount += 1;
			}
		}

		int newLength = length + 2 * spaceCount;
		if (newLength < str.length) {
			str[newLength] = '\0';
		}

		int i = length - 1, j = newLength - 1;
		while (i >= 0) {
			if (str[i] != ' ') {
				str[j--] = str[i--];
			}
			else {
				str[j--] = '0';
				str[j--] = '2';
				str[j--] = '%';
				i--;
			}
		}
	}
}
