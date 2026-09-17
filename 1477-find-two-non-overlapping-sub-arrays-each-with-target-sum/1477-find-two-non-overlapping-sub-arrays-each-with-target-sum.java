class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        int left = 0, sum = 0, res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            while(sum > target) {
                sum -= arr[left];
                left++;
            }
            if(i > 0) minLen[i] = minLen[i - 1];
            if(sum == target) {
                int len = i-left+1;
                if(left > 0 && minLen[left-1] != Integer.MAX_VALUE) {
                    res = Math.min(res, len + minLen[left - 1]);
                }
                minLen[i] = Math.min(len, minLen[i]);
            }
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }
}