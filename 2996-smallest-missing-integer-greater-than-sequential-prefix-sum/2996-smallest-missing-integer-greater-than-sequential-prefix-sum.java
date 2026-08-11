class Solution {
    public int missingInteger(int[] nums) {
        int pre = nums[0];
        int n = nums.length;
        boolean[] arr = new boolean[51];
        arr[nums[0]] = true;
        boolean flag = true;
        for(int i = 1; i < n; i++) {
            if(flag && nums[i] - nums[i - 1] == 1) {
                pre += nums[i];
            } 
            else flag = false;
            arr[nums[i]] = true;
        }
        while(pre <= 50 && arr[pre]) pre++;
        return pre;
    }
}