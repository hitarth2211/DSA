class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int last = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] < lower) continue;
            if(nums[i] > upper) break;
            if(nums[i] > lower) {
                res.add(Arrays.asList(lower, nums[i] - 1));
            }
            lower = 1 + nums[i];
        }
        if(lower <= upper) res.add(Arrays.asList(lower, upper));
        return res;
    }
}