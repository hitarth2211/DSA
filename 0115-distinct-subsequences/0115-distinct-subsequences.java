class Solution {
    // private void backtrack(int idx, String s, String t, StringBuilder sb) {
    //     if(sb.length() == t.length()) {
    //         String str = sb.toString();
    //         if(str.equals(t)) {
    //             res++;
    //         }
    //         return;
    //     }
    //     if(idx >= s.length()) return;

    //     sb.append(s.charAt(idx));
    //     backtrack(idx + 1, s, t, sb);
    //     sb.deleteCharAt(sb.length() - 1);
    //     backtrack(idx + 1, s, t, sb);
    // }
    int memo[][];
    private int solve(int i, int j, String s, String t) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        int res = solve(i + 1, j, s, t);
        if(s.charAt(i) == t.charAt(j)) {
            res += solve(i + 1, j + 1, s, t);
        }
        return memo[i][j] = res;
    }
    public int numDistinct(String s, String t) {
        // StringBuilder sb = new StringBuilder();
        // backtrack(0, s, t, sb);
        memo = new int[s.length()][t.length()];
        for(int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return solve(0, 0, s, t);
    }
}