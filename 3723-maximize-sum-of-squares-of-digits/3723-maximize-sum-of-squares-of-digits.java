class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        int count = 9;
        while(sum != 0 && num >= 0) {
            while(true) {
                if(sum >= count && num > 0) {
                    sb.append(count);
                    sum -= count;
                    num--;
                }
                else if(num == 0 && sum > 0) return  "";
                else break;
            }
            count--;
        }
        if(num > 0) {
            while(num != 0) {
                sb.append('0');
                num--;
            }
        }
        return sb.toString();
    }
}