class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new int[]{v, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a[1], b[1])
        );
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int node = arr[0];
            int weight = arr[1];
            if(weight > dist[node]) continue;
            for(int[] neigh : adj.get(node)) {
                int next = neigh[0];
                int newWeight = neigh[1];
                if(weight + newWeight < dist[next]) {
                    dist[next] = weight + newWeight;
                    pq.offer(new int[]{next, weight + newWeight});
                } 
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}