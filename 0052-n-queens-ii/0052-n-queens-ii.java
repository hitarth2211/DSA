class Solution {
    int res = 0;
    private boolean isValid(int row, int col, char[][] board) {
        for(int i = row; i >= 0; i--) {
            if(board[i][col] == 'Q') return false;
        }
        for(int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    private void solve(int row, char[][] board) {
        if(row == board.length) {
            res++;
            return;
        }
        for(int col = 0; col < board.length; col++) {
            if(isValid(row, col, board)) {
                board[row][col] = 'Q';
                solve(row + 1, board);
                board[row][col] = '.';
            }
        }
    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
        solve(0, board);
        return res;
    }
}