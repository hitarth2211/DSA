class Solution {
    public String smallestSubsequence(String s) {
        boolean[] vis = new boolean[26];
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(!vis[ch - 'a']) {
                while(sb.length() > 0 &&
                sb.charAt(sb.length() - 1) > ch && 
                freq[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    vis[ch - 'a'] = true;
                    sb.append(ch); 
                }
                freq[ch - 'a']--;
            }
        return sb.toString();
    }
}