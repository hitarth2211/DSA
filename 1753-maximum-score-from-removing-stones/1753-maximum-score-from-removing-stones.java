class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (x, y) -> Integer.compare(y, x)
        );
        pq.offer(a);
        pq.offer(b);
        pq.offer(c);
        int res = 0;
        while(!pq.isEmpty()) {
            if(pq.size() < 2) break;
            int x = pq.poll();
            int y = pq.poll();
            res ++;
            x--;
            y--;
            if(x > 0) pq.offer(x);
            if(y > 0) pq.offer(y);
        }
        return res;
    }
}