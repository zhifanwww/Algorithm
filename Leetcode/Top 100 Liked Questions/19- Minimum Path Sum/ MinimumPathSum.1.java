class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        memo[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            memo[i][0] = grid[i][0] + memo[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            memo[0][i] = grid[0][i] + memo[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int k = 1; k < n; k++) {
                memo[i][k] = Math.min(memo[i - 1][k] + grid[i][k], memo[i][k - 1] + grid[i][k]);
            }
        }
        return memo[m - 1][n - 1];
    }
}

/*
 * Recap:
 * 
 * Use a memo to calculate the most current minimum path sum
 */