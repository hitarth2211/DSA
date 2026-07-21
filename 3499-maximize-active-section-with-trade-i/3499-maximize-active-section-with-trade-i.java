class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int count1 = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '1') count1++;
        }
        int prev = -1;
        int curr = 0;
        int bestGain = 0;
        int i = 0;
        int n = s.length();
        while(i < n) {
            char ch = s.charAt(i);
            int start = i;
            while(i < n && s.charAt(i) == ch) i++;
            if(s.charAt(start) == '0') {
                curr = i - start;
                if(prev != -1) {
                    bestGain = Math.max(bestGain, curr + prev);
                }
                prev = curr;
            }
        }
        return count1 + bestGain;
    }
}