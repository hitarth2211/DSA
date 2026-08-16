class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length(), m = station.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int p = 0;
        for(int i = 0; i < n; i++) {
            while(skill.charAt(i) != station.charAt(p)) p++;
            left[i] = p;
            p++;  
        }
        p = m - 1; 
        for(int i = n - 1; i >= 0; i--) {
            while(skill.charAt(i) != station.charAt(p)) p--;
            right[i] = p;
            p--;
        }
        int res = 0;
        for(int i = 1; i < n; i++) {
            res = Math.max(res, right[i] - left[i - 1]);
        }
        return res;
    }
}