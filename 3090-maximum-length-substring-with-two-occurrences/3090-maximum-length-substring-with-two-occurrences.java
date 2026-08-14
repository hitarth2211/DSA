class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int n = s.length(), left = 0, res  = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            while(freq[ch - 'a'] > 2) {
                char prevCh = s.charAt(left); 
                freq[prevCh - 'a']--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        } 
        return res;
    }
}