class Solution {
    public int minRotations(String s) {
        int res = 0, cur = 0, n = s.length();
        for(int i = 0; i < n; i++) {
            int no = s.charAt(i) - '0';
            int diff = Math.abs(no - cur);
            res += Math.min(diff, 10 - diff);
            cur = no;
        }
        return res;
    }
}