class Solution {
    public int minMoves(int[] nums) {
        int max = 0, min = Integer.MAX_VALUE;
        for(int x : nums) {
            // max = Math.max(max, x);
            min = Math.min(min, x);
        }
        // if(max == min) return 0;
        // return max - min + 1;
        int res = 0;
        for(int x : nums) {
            res += x - min;
        }
        return res;

    }
}