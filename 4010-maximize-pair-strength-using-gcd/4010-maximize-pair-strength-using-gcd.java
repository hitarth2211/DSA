class Solution {
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public long maxPairStrength(int[] nums) {
        long res = -1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int gcdVal = gcd(nums[i], nums[j]); 
                long val = -1;
                if(gcdVal != 0)
                val = ((long)nums[i] * nums[j])/ (gcdVal * gcdVal);
                res = Math.max(val, res);
            }
        }
        return res;
    }
}