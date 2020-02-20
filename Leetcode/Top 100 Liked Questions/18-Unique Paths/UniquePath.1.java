class Solution {
    private int ret = 0;

    public int uniquePaths(int m, int n) {
        backtracking(m, n, 1, 1);
        return ret;

    }

    private void backtracking(int m, int n, int x, int y) {
        if (x == m && y == n) {
            ret++;
            return;
        }
        if (x <= m - 1 && y <= n)
            backtracking(m, n, x + 1, y);
        if (x <= m && y <= n - 1)
            backtracking(m, n, x, y + 1);

    }
}

/*
 * Exceed time limit
 * 
 * Should use a cache to store results in the next try
 */