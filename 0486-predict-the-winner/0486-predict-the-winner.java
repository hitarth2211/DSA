class Solution {
    int[][] memo;
    private int solve (int i, int j, int[] nums) {
        if(i > j) return 0;
        
        if(i == j) return nums[i];

        if(memo[i][j] != -1) {
           return  memo[i][j];
        }

        int take_i = nums[i] + Math.min(solve(i + 2, j , nums),solve(i + 1, j - 1, nums));
        
        int take_j = nums[j] + Math.min(solve(i + 1, j - 1, nums),solve(i, j - 2, nums));

        return memo[i][j] = Math.max(take_i, take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        memo = new int[21][21];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        int total = 0, n = nums.length;
        for(int x : nums) total += x;
        int p1Score = solve(0, n - 1, nums);
        int p2Score = total - p1Score;
        return p1Score >= p2Score;
    }
}