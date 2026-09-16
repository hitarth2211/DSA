class Solution {
    int mod = 1000000007;
    // int[][] memo;
    // private int solve(int i, int n, int k) {
    //     if(k == 0) return 1;
    //     if(i == n) return 0;

    //     if(memo[i][k] != -1) return memo[i][k];
    //     int take = 0;
    //     for(int j = i+1; j < n; j++) {
    //         take = ( take + solve(j, n, k-1)) % mod;
    //     }
    //     int skip = solve(i + 1, n, k) % mod;
    //     return memo[i][k] = (skip + take) % mod;
    // }
    public int numberOfSets(int n, int K) {
        // memo = new int[1001][1001];
        // for(int i = 0; i < 1001; i++) {
        //     Arrays.fill(memo[i], -1);
        // }
        int[][] dp = new int[1001][1001];
        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for(int k = 1; k <= K; k++) {
            int[] prevRowSum = new int[n+1];
            for(int i = n-1; i >= 0; i--) {
                prevRowSum[i] = (prevRowSum[i+1] + dp[k-1][i]) % mod;
            }
            for(int i = n-1; i >= 0; i--) {
                int take = prevRowSum[i+1] % mod;
                
                int skip = dp[k][i+1] % mod;
                dp[k][i] = (skip + take) % mod;
            }
        }
        return dp[K][0];
    }
}