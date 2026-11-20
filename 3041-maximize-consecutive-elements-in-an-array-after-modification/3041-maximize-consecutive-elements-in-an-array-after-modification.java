class Solution {
    int n;
    int[][] memo;
    private int binarySearch(int start, int target, int[] nums) {
        int left = start, right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else right = mid; 
        }
        if(left < n && nums[left] == target) return left;
        return -1;
    }
    private int solve(int i, int inc, int[] nums) {
        int currVal = nums[i] + inc;
        int len = 1;
        if(memo[i][inc] != -1) return memo[i][inc];

        int j = binarySearch(i+1, currVal+1, nums);
        if(j != -1) {
            len = Math.max(len, 1 + solve(j, 0, nums));
        }

        j = binarySearch(i+1, currVal, nums);
        if(j != -1) {
            len = Math.max(len, 1 + solve(j, 1, nums));
        }

        return memo[i][inc] = len;
    }
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        n = nums.length;
        memo = new int[n+1][2];
        for(int[] row : memo) Arrays.fill(row, -1);
        for(int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(solve(i, 0, nums), solve(i, 1, nums)));
        }
        return res;
    }
}