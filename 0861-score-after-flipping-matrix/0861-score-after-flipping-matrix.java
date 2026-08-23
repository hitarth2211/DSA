class Solution {
    private void inverseRow(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
    }
    private void inverseCol(int[][] grid, int j) {
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][j] == 0) grid[i][j] = 1;
            else grid[i][j] = 0;
        }
    }
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            if(grid[i][0] != 1) inverseRow(grid[i]);
        }
        for(int j = 0; j < n; j++) {
            int ones = 0;
            for(int i = 0; i < m; i++) {
                if(grid[i][j] == 1) ones++;
            }
            if(ones < m - ones) inverseCol(grid, j);
        }
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            int num = 0;
            for(int bit : grid[i]) {
                num = num * 2 + bit;
            }
            res += num;
        }
        return res;
    }
}