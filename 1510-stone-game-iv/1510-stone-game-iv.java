class Solution {
    Boolean[] memo;
    private boolean solve(int n) {
        if(n <= 0) {
            return false;
        }
        if(memo[n] != null) return memo[n];  
        int stones = 0;
        for(int i = 1; i * i <= n; i++) {
            stones = i * i;
            boolean opponentWins;
            opponentWins = solve(n - stones);
            if(!opponentWins) return memo[n] = true;
        }
        return memo[n] = false; 
    }
    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n + 1];
        return solve(n);
    }
}