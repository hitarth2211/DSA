class Solution {
    public int minDeletions(int[] nums) {
        int res = 0, n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i + 1]) res++;
        }
        return res;
    }
}