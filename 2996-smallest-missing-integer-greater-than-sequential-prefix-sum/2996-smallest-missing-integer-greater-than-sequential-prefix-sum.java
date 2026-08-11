class Solution {
    public int missingInteger(int[] nums) {
        int pre = nums[0];
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        boolean flag = true;
        for(int i = 1; i < n; i++) {
            if(flag && nums[i] - nums[i - 1] == 1) {
                pre += nums[i];
            } 
            else flag = false;
            set.add(nums[i]);
        }
        for(int i = pre; i <= 51; i++) {
            if(!set.contains(i)) return i; 
        }
        return pre;
    }
}