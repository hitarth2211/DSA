class Solution {
    int res = 0, m, n;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean dfs(int[][] grid, int i, int j, boolean[][] vis) {
        if(i < 0 || i >= m || j < 0 || j >= n) { 
            return false;
        }
        if(grid[i][j] == 1 || vis[i][j]) {
            return true;
        }
        vis[i][j] = true;
        boolean closed = true;
        for(int[] dir: dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
        
            if(!dfs(grid, ni, nj , vis)) closed = false;
        }
        return closed;
    }
    public int closedIsland(int[][] grid) {
        m = grid.length; n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && !vis[i][j]) {
                    if(dfs(grid, i, j, vis)) res++;
                }
            }
        }
        return res;
    }
}