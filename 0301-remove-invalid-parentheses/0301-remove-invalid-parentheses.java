class Solution {
    Set<String> set;
    int n, maxLength;
    private void solve(String s, int idx, int open, int close, StringBuilder sb) {
        if(idx == n) {
            if(open == close) {
                if(sb.length() > maxLength) {
                    set.clear();
                    maxLength = sb.length();
                    set.add(sb.toString());
                }
                else if(sb.length() == maxLength) 
                    set.add(sb.toString());
            }
            return;
        }            
        if(close > open) return;
        char ch = s.charAt(idx);
        if(ch >= 'a' && ch <= 'z') {
            sb.append(ch);
            solve(s, idx + 1, open, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        else if(ch == '(') {
            // take 
            sb.append(ch);
            solve(s, idx + 1, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);

            // not take
            solve(s, idx + 1, open, close, sb);
        }
        else {
            if(close < open) {
                // only take ')' when '(' > ')'
                sb.append(ch);
                solve(s, idx + 1, open, close + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            // not take ')' 
            solve(s, idx + 1, open, close, sb);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        maxLength = 0;
        n = s.length();
        set = new HashSet<>();
        solve(s, 0, 0, 0, new StringBuilder());
        return new ArrayList<>(set);
    }
}