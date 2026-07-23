class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n==1 || n==2) return n;
        int res = 1;
        while(res <= n) {
            res *= 2;
        }
        return res;
    }
}