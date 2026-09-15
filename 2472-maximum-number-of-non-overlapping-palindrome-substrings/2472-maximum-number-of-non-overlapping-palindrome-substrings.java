class Solution {
    int n;
    int[][] memo;
    // private boolean isPalindrome(String s, int i, int j) {
    //     while(i <= j) {
    //         if(s.charAt(i) != s.charAt(j)) return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
    // private int solve(String s, int k, int i, int j) {
    //     if(i >= n || j >= n) return 0;
    //     if(memo[i][j] != -1) return memo[i][j];
    //     if(isPalindrome(s, i, j)) {
    //         int take = 1 + solve(s, k, j+1, j+k);
    //         int grow = solve(s, k, i, j+1);
    //         int slide = solve(s, k, i+1, j+1);
    //         return memo[i][j] = Math.max(take, Math.max(grow, slide));
    //     }
    //     int  grow = solve(s, k, i, j+1);
    //     int slide = solve(s, k, i+1, j+1);
    //     return memo[i][j] = Math.max(grow, slide);
    // }
    public int maxPalindromes(String s, int k) {
        if(k == 1) return s.length();
        n = s.length();
        // memo = new int[n][n];
        // for(int i = 0; i < n; i++) {
        //     Arrays.fill(memo[i], -1);
        // }
        boolean[][] isPalindrome = new boolean[n+1][n+1];
        for(int l = 1; l <= n; l++) {
            for(int i = 0; i+l <= n; i++) {
                int j = i+l-1;
                if(i == j) {
                    isPalindrome[i][j] = true;
                }
                else if(i+1 == j) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    isPalindrome[i][j] = ((s.charAt(i) == s.charAt(j)) && isPalindrome[i+1][j-1]);
                }
            }
        }
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(isPalindrome[i][j]) {
                    int take = 1 + ((j+k <= n) ? dp[j+1][j+k] : 0); 
                    int grow = dp[i][j+1];
                    int slide = dp[i+1][j+1];
                    dp[i][j] = Math.max(take, Math.max(grow, slide));
                }
                int grow = dp[i][j+1];
                int slide = dp[i+1][j+1];
                dp[i][j] = Math.max(grow, Math.max(dp[i][j], slide));
            }
        }
        return dp[0][k - 1];
    }
}