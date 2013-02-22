// Cracking the Coding Interview 1.6
// Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
// Can you do this in place?

// (x, y) -> (y, n - 1 - x) -> (n - 1 - x, n - 1 - y) -> (n - 1 - y, x) -> (x, y)
// O(n^2) time, O(1) space

import java.util.Arrays;

public class Rotate {
	public static void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix.length - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - 1 - j][i];
				matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
				matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
				matrix[j][matrix.length - 1 - i] = tmp;
			}
		}
	}
}
