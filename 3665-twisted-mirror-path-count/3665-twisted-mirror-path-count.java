class Solution {
    int m, n;
    int[][][] memo;
    int mod = 1000000007;
    private int dfs(int[][] grid, int i, int j, int last) {
        if(i < 0 || i >= m || j < 0 || j >= n) return 0;
        
        if(i == m - 1 && j == n - 1) return 1;

        if(memo[i][j][last] != -1) {
            return memo[i][j][last];
        }
        int res = 0;
        if(grid[i][j] == 1) {
            if(last == 1) {
                res += (dfs(grid, i + 1, j, 2)) % mod;
            }
            else if(last == 2) {
                res += (dfs(grid, i, j + 1, 1)) % mod;
            }
        }
        else{
            res += (dfs(grid, i+1, j, 2)) % mod;
            res += (dfs(grid, i, j+1, 1)) % mod;
        }
        return memo[i][j][last] = res % mod;
    }
    public int uniquePaths(int[][] grid) {
        m = grid.length; n = grid[0].length;
        memo = new int[m][n][3];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(grid, 0, 0, 0) % mod;
    }
}