class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n && j - i + 1 <= r; j++) {
                sum += nums.get(j);
                if(sum > 0 && j - i + 1 >= l) {
                    res = Math.min(sum, res);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}