class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> Integer.compare(b[2], a[2])
        );
   
        for(int[] pair : points) {
            int x = pair[0];
            int y = pair[1];
            int dist = (x * x + y * y);
            pq.offer(new int[]{x, y, dist});
            if(pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            res[i][0] = arr[0];
            res[i][1] = arr[1];
            i++;
        } 
        return res;
    }
}