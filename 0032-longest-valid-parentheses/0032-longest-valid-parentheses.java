class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0, n = s.length(), res = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else close++;
            if(close > open) {
                open = 0;
                close = 0;
            }
            else if(open == close) {
                res = Math.max(res, open + close);
            }
        }
        open = close = 0;
        for(int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else close++;
            if(open > close) {
                open = 0;
                close = 0;
            }
            else if(open == close) {
                res = Math.max(open + close, res);
            }
        }
        return res;
    }
}