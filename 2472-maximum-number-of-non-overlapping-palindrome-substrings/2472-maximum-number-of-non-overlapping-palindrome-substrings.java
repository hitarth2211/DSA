class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        boolean[][]dp=new boolean[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0;len+i-1<n;i++){
                int j=len+i-1;
                if(len==1)dp[i][j]=true;
                else if(len==2) dp[i][j]=(s.charAt(i)==s.charAt(j));
                else dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
            }
        }
        int[] dp1= new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            dp1[i] = dp1[i + 1]; // skip

            for (int j = i + k - 1; j < n; j++) {
                if (dp[i][j]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j + 1]);
                }
            }
        }

        return dp1[0];
    }
}