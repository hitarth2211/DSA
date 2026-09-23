class Solution {
    int n;
    // private int solve(int[] nums, int x, int left, int right) {
    //     if(x == 0) return 0;
    //     if(left > right || x < 0) return -1;
    //     int takeLeft = solve(nums, x - nums[left], left + 1, right);
    //     int takeRight = solve(nums, x - nums[right], left, right - 1);
    //     if(takeLeft != -1) takeLeft++;
    //     if(takeRight != -1) takeRight++;

    //     if(takeLeft == -1 && takeRight == -1) return -1;

    //     if(takeLeft == -1) return takeRight;
    //     if(takeRight == -1) return takeLeft;

    //     return Math.min(takeLeft, takeRight);
    // }
    public int minOperations(int[] nums, int x) {
        n = nums.length;
        // return solve(nums, x, 0, n-1);
        int total = 0;
        for(int e : nums) total += e;
        if(x > total) return -1;
        if(total == x) return n;
        total = total - x;
        int left = 0, sum = 0, res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            while(sum > total) {
                sum -= nums[left];
                left++;
            }
            if(sum == total)
                res = Math.max(res, i - left + 1);
        }
        return res == Integer.MIN_VALUE ? -1 : n - res;
    }
}