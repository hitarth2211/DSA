class Solution {
    private boolean canMake(int mid, int[] bloomDay, int m, int k) {
        int count = 0, consecutive = 0;
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] > mid) consecutive = 0;
            else consecutive++;
            if(consecutive == k) {
                count++;
                consecutive = 0;
            }
        }
        return count >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m * k > n) return -1;
        int high = 0;
        int low = Integer.MAX_VALUE;// we can take low = 1 but if there is 5 in bloomDay then first flowers requires 5 to bloom so 1,2,3,4 days are waste
        for(int x : bloomDay) {
            high = Math.max(x , high);
            low = Math.min(x, low);
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canMake(mid, bloomDay, m, k)){
                high = mid-1;
            }
            else low = mid + 1;
        }
        return low;
    }
}