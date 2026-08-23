class Solution {
    public boolean sumGame(String num) {
        int leftSum = 0, rightSum = 0;
        int leftQuestions = 0, rightQuestions = 0;
        int n = num.length();
        for(int i = 0; i < n; i++) {
            if(num.charAt(i) == '?') {
                if(i < n / 2) {
                    leftQuestions++;
                }
                else rightQuestions++;
            }
            else {
                if(i < n / 2) {
                    leftSum += num.charAt(i) - '0';
                }
                else rightSum += num.charAt(i) - '0';
            }
        }
        int totalQuestions = leftQuestions + rightQuestions;
        if(totalQuestions % 2 == 1) return true;
        int left = 2 * leftSum + 9 * leftQuestions;
        int right = 2 * rightSum + 9 * rightQuestions;
        if(left == right) return false;
        return true;
    }
}