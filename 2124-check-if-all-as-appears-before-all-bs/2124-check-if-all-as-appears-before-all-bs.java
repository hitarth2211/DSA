class Solution {
    public boolean checkString(String s) {
        int countA = 0, countB = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a') {
                if(countB != 0) return false;
                countA++;
            }
            else countB++;
        } 
        return true;
    }
}