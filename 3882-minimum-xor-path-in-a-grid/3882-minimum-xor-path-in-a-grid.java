class Solution {
    int m, n;
    int[][] dirs = {{1, 0}, {0, 1}};
    int[][][] memo;
    private int dfs(int[][] grid, int i, int j, int xor) {
        if(i < 0 || i >= m || j < 0 || j >= n) return Integer.MAX_VALUE;
        if(i == m - 1 && j == n - 1) return xor ^ grid[i][j];
        if(memo[i][j][xor] != -1) return memo[i][j][xor]; 
        int res = Integer.MAX_VALUE;
        for(int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            // if(ni < m && nj < n)
                res = Math.min(res, dfs(grid, ni, nj, xor ^ grid[i][j]));
        }

        return memo[i][j][xor] = res;
    }
    public int minCost(int[][] grid) {
        m = grid.length; n = grid[0].length;
        memo = new int[m + 1][n + 1][10001];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(grid, 0, 0, 0);
    }
}