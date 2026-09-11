class Solution {
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    private int solve(int r, int c, int[][] board) {
        int count = 0;
        for(int[] dir: dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                if(board[nr][nc] == 1 || board[nr][nc] == 2) count++;
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int die = 2, live = 3;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = solve(i, j, board);
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = live;
                }
                else if(board[i][j] == 1) {
                    if(count == 2 || count == 3) continue;
                    else if(count < 2 || count > 3) board[i][j] = die;
                }
            }
        } 
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
}