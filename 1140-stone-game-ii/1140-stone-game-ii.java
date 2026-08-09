class Solution {
    int[][][] memo;
    private int solve(int person, int i, int m, int[] piles) {
        int n = piles.length;
        if(i >= n) return 0;
        if(memo[person][i][m] != -1) {
            return memo[person][i][m];
        }
        int stones = 0;
        int res = (person == 0) ? -1 : Integer.MAX_VALUE;
        for(int x = 1; x <= Math.min(2 * m, n - i); x++) {
            stones += piles[i + x - 1];
            if(person == 0) {
                res = Math.max(res,stones + solve(1, i + x, Math.max(m, x),piles));
            }
            else {
                res = Math.min(res, solve(0, i + x, Math.max(m, x),piles));
            }
        }
        return memo[person][i][m] = res;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        memo =  new int[2][n + 1][n + 1];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return solve(0, 0, 1, piles);
    }
}