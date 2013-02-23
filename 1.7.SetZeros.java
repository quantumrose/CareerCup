// Cracking the Coding Interview 1.7
// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.

import java.util.Arrays;

public class SetZeros {
	// O(mn) time, O(m + n) space
	public static void setZeros(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		// could use bit vector for more efficiency
		boolean[] row = new boolean[m];
		boolean[] column = new boolean[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
