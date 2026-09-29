class Solution {
    int m, n;
    int[][] dirs = {{0,1},{1,0}};
    int[][][] memo;
    private boolean solve(char[][] grid, int i, int j, int res) {
        if(i >= m || j >= n) return false; 
        if(grid[i][j] == '(') res++;
        else res--;
        if(res < 0) return false;
        if(memo[i][j][res] != -1) return memo[i][j][res] == 1;
        if(i == m - 1 && j == n - 1) {
            memo[i][j][res] = res == 0 ? 1 : 2;
            return res == 0;
        }
        for(int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n) {
                if(solve(grid, r, c, res)) {
                    memo[i] [j][res] = 1;
                    return true;
                }
            }
        }
        memo[i][j][res] = 2;
        return false;
    }
    public boolean hasValidPath(char[][] grid) {
        m = grid.length; n = grid[0].length;
        memo = new int[m][n][m + n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return solve(grid, 0, 0, 0);
    }
}