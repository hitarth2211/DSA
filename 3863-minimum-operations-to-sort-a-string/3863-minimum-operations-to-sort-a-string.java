class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;
        char min = 'z'; char max = 'a';
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            max = (char) Math.max(max, ch);
            min = (char) Math.min(min, ch);
            if(i > 0 && s.charAt(i - 1) > ch) isSorted = false;
        }
        if(isSorted) return 0;
        if(n == 2) return -1;
        if(min == s.charAt(0) || max == s.charAt(n - 1))return 1;
        for(int i = 1; i < n - 1; i++) {
            if(s.charAt(i) == min | s.charAt(i) == max)
                return 2;        
        }
        return 3;
    }
}