class Solution {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(word, board, i, j) == true) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(String word, char[][] board, int i, int j) {

        if (word.length() == 0) {
            return true;
        } else if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(0)) {
            return false;
        } else {
            char tmp = board[i][j];
            board[i][j] = '#'; // Mark visited nodes!!!
            boolean res = dfs(word.substring(1), board, i + 1, j) || dfs(word.substring(1), board, i, j + 1)
                    || dfs(word.substring(1), board, i, j - 1) || dfs(word.substring(1), board, i - 1, j);
            board[i][j] = tmp;
            return res;

        }

    }
}

/* Intuitive dfs solution */