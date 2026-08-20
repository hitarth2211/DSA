class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        temp[0] = nums[0];
        temp[n - 1] = nums[1];
        int idx = 1;
        int revIdx = n - 2;
        for(int i = 2; i < n; i++) {
            if(temp[idx - 1] > temp[revIdx + 1]) {
                temp[idx++] = nums[i]; 
            }
            else temp[revIdx--] = nums[i];
        }
        int l = revIdx + 1, r = n - 1;
        while(l < r) {
            int tmp = temp[l];
            temp[l] = temp[r];
            temp[r] = tmp; 
            l++;
            r--;
        }
        return temp;
    }
}