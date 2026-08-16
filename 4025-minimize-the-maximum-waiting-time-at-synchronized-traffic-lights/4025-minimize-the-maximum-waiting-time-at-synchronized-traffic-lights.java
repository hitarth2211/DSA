class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int n = lights.length;
        int m = arrivalTime.length;
        int max = 0;
        for(int x : lights) max = Math.max(x, max);
        // Arrays.sort(lights);
        // Arrays.sort(arrivalTime);
        int left = 0, right = lights.length - 1;
        int temp = Integer.MIN_VALUE;
        int res = 0;
        for(int i = 0; i < m; i++) {
            int r = arrivalTime[i] % period;
            int wait = (r < max) ? 0 : period - r;
            res = Math.max(res, wait);
        }
        // while(right >= 0) {
        //     if(n - right > m - left) {
        //         int r = arrivalTime[left] % period;
        //         if(r < lights[right]) temp = Math.max(0, temp);
        //         else temp = Math.max(temp, period - r); 
        //         left++;
        //     }
        //     else {
        //         int r = arrivalTime[left] % period;
        //         if(r < lights[right]) temp = Math.max(0, temp);
        //         else temp = Math.max(temp, period - r); 
        //         left++;
        //         right--;
        //     }
        //     res = Math.min(res, temp);
        // }
        return res;
    }
}