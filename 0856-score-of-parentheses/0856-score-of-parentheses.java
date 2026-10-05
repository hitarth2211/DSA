class Solution {
    public int scoreOfParentheses(String s) {
        int depth = 0, res = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') depth++;
            else {
                if(s.charAt(i - 1) == '(') {
                    depth--;
                    res += (1 << depth);
                }
                else depth--;
            }
        }
        return res;
    }
}