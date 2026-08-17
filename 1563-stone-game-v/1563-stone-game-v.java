class Solution {
    int[][] memo;
    int[] prefix;
    private int solve(int[] stoneValue, int left, int right) {
        if(left == right) return 0;
        if(memo[left][right] != -1) {
            return memo[left][right];
        }
        int max = 0;
        for(int i = left; i < right; i++) {
            int leftSum = prefix[i + 1] - prefix[left];
            int rightSum = prefix[right + 1] - prefix[i + 1];
            if(leftSum < rightSum) {
                max = Math.max(max, leftSum + solve(stoneValue, left, i));
            }
            else if(rightSum < leftSum) {
                max = Math.max(max, rightSum + solve(stoneValue, i + 1, right));
            }
            else {
                max = Math.max(max, leftSum + 
                    Math.max(solve(stoneValue, left, i),
                    solve(stoneValue, i + 1, right))
                );
            }
        }
        return memo[left][right] = max;
    } 
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        prefix = new int[n + 1];
        prefix[0] = stoneValue[0];
        for(int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        } 
        memo = new int[n][n];
        for(int[] row : memo) Arrays.fill(row, -1);
        return solve(stoneValue, 0, n - 1);
    }
}