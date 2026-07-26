class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = -1001;
        int max2 = -1001;
        int max3 = -1001;
        
        int min1 = 1001;
        int min2 = 1001;
        int min3 = 1001;

        for(int n : nums) {
            if(n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if(n >= max2) {
                max3 = max2;
                max2 = n;
            }
            else if(n >= max3) max3 = n;
        }
        for(int n : nums) {
            if(n <= min1) {
                min3 = min2;
                min2 = min1;
                min1 = n;
            }
            else if(n <= min2) {
                min3 = min2;
                min2 = n;
            }
            else if(n <= min3) min3 = n;
        }
        return Math.max(max1*max2*max3,
        Math.max(min1*min2*min3,max1*min1*min2));
    }
}