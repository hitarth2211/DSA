class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int res=Integer.MAX_VALUE;
        int n = nums.length;
        int[] preMax = new int[n];
        int[] sufMin = new int[n];
        preMax[0] = nums[0];
        for(int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }
        sufMin[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            sufMin[i] = Math.min(nums[i], sufMin[i + 1]);
        }
        for(int i = 0; i < n; i++) {
            if(preMax[i] - sufMin[i] <= k) 
                res = Math.min(res, i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}