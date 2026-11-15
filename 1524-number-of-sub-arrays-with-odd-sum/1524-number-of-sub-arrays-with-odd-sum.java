class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007, n = arr.length, res = 0;
        int preSum = 0, evenSumCount = 1, oddSumCount = 0;
        for(int i = 0; i < n; i++) {
            preSum += arr[i];
            if((preSum & 1) == 1) {
                res = (res + evenSumCount) % mod;
                oddSumCount++;
            }
            else {
                res = (res + oddSumCount) % mod;
                evenSumCount++;
            }
        }
        return res;
    }
}