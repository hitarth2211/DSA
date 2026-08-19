class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if(i == k) {
                q.offer(new int[]{tickets[i], 1});
                continue;
            }
            q.offer(new int[]{tickets[i],0});
        }
        int res = 0;
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int rem = arr[0];
            int flag = arr[1];
            if(rem == 1 && flag == 1) {
                res++;
                return res;
            }
            if(rem > 0) {
                q.offer(new int[]{rem - 1, flag});
                res++;
            }
        }
        return -1;
    }
}