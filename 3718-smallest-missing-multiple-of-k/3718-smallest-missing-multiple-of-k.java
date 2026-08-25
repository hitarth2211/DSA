class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        boolean[] check = new boolean[201];
        for(int i = 0; i < n; i++) {
            check[nums[i]] = true;
        }
        for(int i = 1; i < 201; i++) {
            if(check[i] == false && i % k == 0) return i;
        }
        return -1;
    }
}