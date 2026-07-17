class Solution {
    public int minimumCost(int[] nums, int k) {
        long cost = 0;int n = nums.length;long total = k;
        int MOD = (int)1e9+7;
        for(int i = 0; i < n; i++){
            if(total < nums[i]){
                long need = nums[i] - total;
                long x = ((need + k - 1) / k) ;
                cost += x;
                total += (x * k) ;
            }
            total -= nums[i];
        }
        long res = (cost % MOD) * ((cost + 1) % MOD) % MOD;
        res = res * 500000004L % MOD;
        return (int)res;
    }
}