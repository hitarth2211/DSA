class Solution {
    int m, n;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private long dfs(int[][] grid, int i, int j, boolean[][] vis) {
        if(i < 0 || i >= m || j < 0 || j >= n) return 0;
        if(vis[i][j] || grid[i][j] == 0) return 0;
        vis[i][j] = true;
        long sum = grid[i][j];
        for(int[] dir: dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            sum += dfs(grid, ni, nj, vis);
        }
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        m = grid.length; n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0 && !vis[i][j]) {
                    long sum = dfs(grid, i, j, vis);
                    if(sum % k == 0) res++;
                }
            }
        }
        return res;
    }
}