class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<=i;j++){
                max=Math.max(nums[j],max);
            }
            int min=Integer.MAX_VALUE;
            for(int j=i;j<nums.length;j++){
                min=Math.min(nums[j],min);
            }
            if(max-min<=k)
            res=Math.min(res,i);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}