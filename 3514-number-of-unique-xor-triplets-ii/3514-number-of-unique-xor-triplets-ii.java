class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        boolean[] res = new boolean [2048 + 1];
        boolean[] pair = new boolean[2048 + 1]; 
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }
        for(int x = 0; x <= 2048; x++) {
            if(!pair[x]) continue;
            for(int num : nums) {
                res[(x ^ num)] = true;
            }
        }
        int count = 0;
        for(boolean f : res) if(f) count++;
        return count;
    }
}