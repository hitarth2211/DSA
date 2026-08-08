class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) freq[ch - 'a']++;
        boolean[] vis = new boolean[26];
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']--;
            if(vis[ch - 'a']) continue;
            while(!st.isEmpty() && 
            st.peek() > ch && 
            freq[st.peek() - 'a'] > 0) {
                vis[st.pop() - 'a'] = false;
            }
            vis[ch - 'a'] = true;
            st.push(ch);    
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : st) {
            sb.append(ch);
        }
        return sb.toString();
    }
}