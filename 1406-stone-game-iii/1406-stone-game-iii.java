class Solution {
    // int[] memo;
    // private int solve(int i, int[] nums) {
    //     if(i >= nums.length) return 0;
    //     int diff = Integer.MIN_VALUE;

    //     if(memo[i] != -1001) return memo[i];

    //     diff = Math.max(diff, nums[i] - solve(i + 1, nums));

    //     if(i + 1 < nums.length)
    //         diff = Math.max(diff, nums[i] + nums[i + 1] - 
    //         solve(i + 2, nums));

    //     if(i + 2 < nums.length)
    //         diff = Math.max(diff, nums[i] + nums[i + 1] + nums[i + 2] - solve(i + 3, nums));

    //     return memo[i] = diff; 
    // }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        // memo = new int[n];
        // Arrays.fill(memo, -1001);
        // int diff = solve(0, stoneValue);
        // if(diff == 0) return "Tie";
        // return diff > 0 ? "Alice" : "Bob";

        int[] dp = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            dp[i] = stoneValue[i] - dp[i + 1];
            if(i + 1 < n) 
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - dp[i + 2]);
            if(i + 2 < n) 
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3]);    
        }

        if(dp[0] == 0) return "Tie";
        return dp[0] > 0 ? "Alice" : "Bob";  
    }
}