class Solution {
    public int minInsertions(String s) {
        int open = 0, close = 0, minimumRequired = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else{
                if(i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                }
                else {
                    minimumRequired++;
                }

                if(open > 0) {
                    open--;
                }
                else {
                    minimumRequired++;
                }
            }
        }
        return open * 2 + minimumRequired;
    }
}