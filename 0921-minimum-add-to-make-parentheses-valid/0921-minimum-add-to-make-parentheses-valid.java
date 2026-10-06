class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int minAddsReq = 0, n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else {
                if(open == 0) minAddsReq++;
                else open--;
            }
        }
        return open + minAddsReq;
    }
}