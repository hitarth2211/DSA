class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int high = nums[n-3] - nums[0];
        high = Math.min(high, Math.min(nums[n-2] - nums[1], nums[n-1] - nums[2]));
        return high;
    }
}