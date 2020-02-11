class Solution {
    public void rotate(int[][] matrix) {
        int n = (int) Math.floor(matrix.length / 2);
        for (int i = 0; i <= n; i++) {
            for (int m = i; m <= matrix.length - 2 - i; m++) {
                swapCircle(i, m, m, matrix.length - 1 - i, matrix[i][m], matrix);
            }
        }
    }

    private void swapCircle(int x, int y, int nextx, int nexty, int value, int[][] matrix) {

        if (nextx == x && nexty == y) {
            matrix[nextx][nexty] = value;
            return;
        } else {
            int temp = matrix[nextx][nexty];
            matrix[nextx][nexty] = value;
            swapCircle(x, y, nexty, matrix.length - 1 - nextx, temp, matrix);
        }

    }
}