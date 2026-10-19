class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length, count = 0, smallCount = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) count++;
            else if(nums[i] < target)
                smallCount++;
        }
        for(int i = 0; i < count; i++) {
            res.add(smallCount++);
        }
        return res;
    }
}