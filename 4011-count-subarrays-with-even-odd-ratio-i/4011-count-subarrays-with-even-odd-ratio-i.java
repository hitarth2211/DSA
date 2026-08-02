class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int[] even = new int[n + 1];
        int[] odd = new int[n + 1];
        for(int i = 0; i < n; i++) {
            even[i + 1] = even[i];
            odd[i + 1] = odd[i];
            if(nums[i] % 2 == 0) even[i + 1]++;
            else odd[i + 1]++;
        }
        int res = 0;
        for(int l = 0; l < n; l++) {
            for(int r = l; r < n; r++) {
                int x = even[r + 1] - even[l];
                int y = odd[r + 1] - odd[l];
              if(y > 0 && (long) x*b <= (long) y*a) res++;
            }
        }
        return res;
    }
}