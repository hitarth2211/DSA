class Solution {
    String res = "";
    int n;
    // boolean[] vis;
    // backtracking give TLE
    // private void solve(String s , String target, StringBuilder sb) {
    //     if(sb.length() == n) {
    //         String curr = sb.toString();
    //         if(curr.compareTo(target) > 0 && 
    //         (res.equals("") || curr.compareTo(res) < 0)) {
    //             res = curr;
    //         }
    //         return;
    //     }
    //     for(int i = 0; i < n; i++) {
    //         if(vis[i] == true) continue;
    //         vis[i] = true;
    //         sb.append(s.charAt(i));
    //         solve(s, target, sb);
    //         sb.deleteCharAt(sb.length() - 1);
    //         vis[i] = false;
    //     }
    // }
    private boolean solve(int i, String target, StringBuilder sb, boolean greater, int[] freq) {
        if(i == target.length()) {
            if(greater) {
                res = sb.toString();
                return true;
            }
            return false;
        }
        for(char ch = 'a'; ch <= 'z'; ch++) {
            if(freq[ch - 'a'] == 0) continue;
            if(greater == false && ch < target.charAt(i)) continue;

            sb.append(ch);
            freq[ch - 'a']--;

            boolean isGreater = greater || ch > target.charAt(i);
            if(solve(i + 1, target, sb, isGreater, freq))  return true;

            sb.deleteCharAt(sb.length() - 1);
            freq[ch - 'a']++;
        }
        return false;
    }
    public String lexGreaterPermutation(String s, String target) {
        n = s.length();
        // vis = new boolean[n];
        // StringBuilder sb = new StringBuilder();
        // solve(s, target, sb);
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        boolean greater = false;
        StringBuilder sb = new StringBuilder();
        solve(0, target, sb, greater, freq);
        return res;
    }
}