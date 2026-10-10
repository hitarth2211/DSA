class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long total = k1 + k2;

        // gives TLE
        // PriorityQueue<Long> pq = new PriorityQueue<>(
        //     (a, b) -> Long.compare(b, a)
        // );
        // for(int i = 0; i < n; i++) {
        //     pq.offer((long)Math.abs(nums1[i] - nums2[i]));
        // }
        // while(total != 0) {
        //     long x = pq.poll();
        //     if(x == 0) break;
        //     if(x > 0) x--;
        //     pq.offer(x);
        //     total--;
        // }
        // long res = 0;
        // while(!pq.isEmpty()) {
        //     long x = pq.poll();
        //     long square = x * x;
        //     res += square;
        // }
        // return res;

        int[] countDiff = new int[100005 + 1];
        for(int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            countDiff[d]++;
        }
        for(int i = 100005; i > 0 && total > 0; i--) {
            int operations = (int)Math.min(total, countDiff[i]);
            countDiff[i] -= operations;
            countDiff[i - 1] += operations;
            total -= operations; 
        }
        long res = 0;
        for(long i = 1; i <= 100005; i++) {
            res += (long)(countDiff[(int)i] * i*i);
        }
        return res;
    }
}