class Solution {
    Boolean[][][] memo;
    private boolean solve(String s, int i, int open, int close) {
        if(close > open) return false;
        if(i >= s.length()) return open == close;
        if(memo[i][open][close] != null) return memo[i][open][close];
        if(s.charAt(i) == '(') return memo[i][open][close] = solve(s, i + 1, open + 1, close);
        else if(s.charAt(i) == ')') return memo[i][open][close] = solve(s, i + 1, open, close + 1);
        else {
            return memo[i][open][close] = solve(s, i + 1, open + 1, close) ||
            solve(s, i + 1, open, close + 1) ||
            solve(s, i + 1, open, close);
        }
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new Boolean[n][n][n];
        return solve(s, 0, 0, 0);
    }
}