class Solution {
    String str;
    int n;
    int[][] memoCost;
    int[][] memoSolve;
    public int getCost(int i, int j) {
        int len = j-i+1;
        int minCost = Integer.MAX_VALUE;
        if(memoCost[i][j] != -1) return memoCost[i][j];
        for(int d = 1; d < len; d++) {
            if(len % d != 0) continue;
            int cost = 0;
            for(int group = 0; group < d; group++) {
                int l = i + group;
                int r = l + (len/d - 1) * d;
                while(l < r) {
                    if(str.charAt(l) != str.charAt(r)) cost++;
                    l += d;
                    r -= d;
                }
            }
            minCost = Math.min(cost, minCost);
        }
        return memoCost[i][j] = minCost;
    }
    public int solve(int start, int k) {
        if(k == 0) {
            if(start == n) return 0;
            else return Integer.MAX_VALUE;
        }
        if(start + 2 * k > n) return Integer.MAX_VALUE;
        if(memoSolve[start][k] != -1) return memoSolve[start][k];
        int res = Integer.MAX_VALUE;
        for(int end = start+1; end < n; end++) {
            int remainingCost = solve(end+1, k-1);
            if(remainingCost == Integer.MAX_VALUE) continue;
            res = Math.min(res, getCost(start, end) + remainingCost);
        }
        return memoSolve[start][k] = res;
    }
    public int minimumChanges(String s, int k) {
        n = s.length();
        str = s;
        memoCost = new int[n+1][n+1];
        memoSolve = new int[n+1][k+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(memoCost[i], -1);
            Arrays.fill(memoSolve[i], -1);
        }
        return solve(0, k);
    }
}