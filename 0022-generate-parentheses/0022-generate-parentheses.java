class Solution {
    List<String> res;
    private void solve(int open, int close, int n, StringBuilder sb) {
        if(open == n &&  close == n) {
            res.add(sb.toString());
            return;
        }
        if(open < n) {
            sb.append('(');
            solve(open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open) {
            sb.append(')');
            solve(open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0, 0, n, sb);
        return res;
    }
}