class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0, zeros = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) zeros++;
            xor ^= nums[i];
        }
        if(zeros == n) return 0;
        return xor == 0 ? n - 1 : n; 
    }
}