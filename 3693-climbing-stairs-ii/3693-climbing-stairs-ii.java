class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = n - 1; i >= 0; i--) {
            int j = i+1;
            int cost = Integer.MAX_VALUE;
            if(j <= n){
                cost = dp[j] + costs[j-1] + (j-i) * (j-i);
            }
            j = i+2;
            if(j <= n) {
                cost = Math.min(cost, 
                dp[j] + costs[j-1] + (j-i) * (j-i));
            } 
            j = i+3;
            if(j <= n) {
                cost = Math.min(cost, 
                dp[j] + costs[j-1] + (j-i) * (j-i));
            } 
            dp[i] = cost;
        }
        return dp[0];
    }
}