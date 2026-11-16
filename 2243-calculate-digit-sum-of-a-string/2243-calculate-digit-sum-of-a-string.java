class Solution {
    public String digitSum(String s, int k) {
        int n = s.length();
        while(n > k) {
            StringBuilder temp = new StringBuilder();
            int sum = 0, count = 0;
            for(int i = 0; i < n; i++) {
                sum += s.charAt(i) - '0';
                count++;
                if(count == k || i == s.length() - 1) {
                    temp.append(sum);
                    count = 0;
                    sum = 0;
                }
            }
            s = temp.toString();
            n = s.length();
        }
        return s;
    }
}