class Solution {
    public int minimumPushes(String word) {
        int res = 0;
        int count = 0, idx = 2;
        for(int i = 0; i < word.length(); i++) {
            res += count + 1;
            if(idx == 9) {
                idx = 2;
                count++;
            }
            else idx++;
        }
        return res;
    }
}