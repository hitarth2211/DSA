class Solution {
    private void reverse(int[][] grid, int i, int j) {
        int col = grid[0].length;
        while(i <= j){
            int temp = grid[i/col][i%col];
            grid[i/col][i%col] = grid[j/col][j%col];
            grid[j/col][j%col] = temp;
            i++;
            j--; 
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int row = grid.length, col = grid[0].length;
        int n = row * col;
        k = k % n;
        reverse(grid, 0, n - 1);
        reverse(grid, 0, k - 1);
        reverse(grid, k, n - 1);
        for(int[] r : grid) {
            List<Integer> list = new ArrayList<>();
            for(int num : r) {
                list.add(num);
            }
            res.add(list);
        }
        return res;
    }
}