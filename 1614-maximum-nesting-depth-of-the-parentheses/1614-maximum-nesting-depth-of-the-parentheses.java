class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int curr = 0, n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') curr++;
            else if(ch == ')') curr--;
            max = Math.max(curr, max);
        }
        return max;
    }
}