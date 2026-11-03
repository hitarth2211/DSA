class Solution {
    public int minMoves(int[] nums) {
        int sum = 0, res = 0, max = -1, n = nums.length;
        for(int x : nums) {
            max = Math.max(x, max);
            sum += x;
        }
        return n * max - sum;
    }
}