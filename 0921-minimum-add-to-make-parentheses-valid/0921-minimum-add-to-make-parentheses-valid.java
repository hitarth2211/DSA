class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int minOpenAddsReq = 0, n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else {
                if(open == 0) minOpenAddsReq++;
                else open--;
            }
        }
        return open + minOpenAddsReq;
    }
}