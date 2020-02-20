class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (i == 0 || k == 0)
                    matrix[i][k] = 1;
                else
                    matrix[i][k] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int k = 1; k < n; k++) {
                matrix[i][k] = matrix[i - 1][k] + matrix[i][k - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }
}

/*
 * Recap:
 * 
 * Use a 2d array as memo to save all unique paths of every point
 */
