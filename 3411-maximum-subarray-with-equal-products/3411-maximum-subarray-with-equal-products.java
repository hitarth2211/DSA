class Solution {
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    } 
    public int maxLength(int[] nums) {
        int n = nums.length;
        int res = 2;
        for(int i = 0; i < n; i++) {
            int prod = nums[i];
            int gcd = nums[i];
            int lcm = nums[i];
            for(int j = i+1; j < n; j++) {
                prod *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = (lcm * nums[j]) / gcd(lcm, nums[j]);
                if(prod == lcm * gcd) {
                    res = Math.max(res, j-i+1);
                } 
            }
        }
        return res;
    }
}