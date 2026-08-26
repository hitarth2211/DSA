class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0, count = 0;
        int n = s.length();
        int len = 0;
        String res = "";
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '1') count++;
            while(count > k) {
                if(s.charAt(left) == '1') count--;
                left++;
            }
            if(count == k) {
                while(s.charAt(left) == '0') left++;
                
                String curr = s.substring(left, i + 1);
                if(res.equals("") ||
                curr.length() < res.length() ||
                (res.length() == curr.length() && curr.compareTo(res) < 0)) res = curr;
            }
        }
        return res;
    }
}