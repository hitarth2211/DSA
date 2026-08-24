class Solution {
    // int[] memo;
    // private int solve(int i, int[] prefixSum) {
    //     if(i == prefixSum.length - 1) {
    //         return prefixSum[prefixSum.length - 1];
    //     }
    //     if(memo[i] != -1) return memo[i];
    //     int take = prefixSum[i] - solve(i + 1, prefixSum);
    //     int skip = solve(i + 1, prefixSum);
    //     return memo[i] = Math.max(take, skip);
    // }
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefixSum = new int[n];
        // memo = new int[n];
        // Arrays.fill(memo, -1);
        int[] dp = new int[n];
        prefixSum[0] = stones[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }
        dp[n - 1] = prefixSum[n - 1];
        for(int i = n - 2; i >= 1; i--) {
            int take = prefixSum[i] - dp[i + 1]; 
            int skip = dp[i + 1];
            dp[i] = Math.max(take, skip); 
        }
        return dp[1];
    }
}