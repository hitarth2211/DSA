class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length(); 
        int[] res = new int[m];
        int[] rightHandMatching = new int[n];
        Arrays.fill(rightHandMatching, 0);
        int rightCount = 0, k = m - 1;
        for(int i = n - 1; i >= 0; i--){
            if(k >= 0 && word1.charAt(i) == word2.charAt(k)) {
                rightCount++;
                k--;
            }
            rightHandMatching[i] = rightCount; 
        }
        int j = 0; boolean changePower = true;
        for(int i = 0; i < n; i++) {
            if(j < m && word1.charAt(i) == word2.charAt(j)) {
                res[j] = i;
                j++;
            }
            else if(j < m && i + 1 < n && changePower && rightHandMatching[i + 1] >= m - j - 1) {
                res[j] = i;
                changePower = false;
                j++;
            }
        }
        if(j < m) return new int[]{};
        return res;
    }
}