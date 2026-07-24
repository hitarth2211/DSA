class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) q.offer(i);
        while(q.size() != 1) {
            int c = 0;
            while(c < k - 1){
                q.offer(q.poll());
                c++;
            }
            q.poll();
        }
        return q.poll();
    }
}