class Solution {
    private long[] dijkstra(int src, List<List<int[]>> adj) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a,b)->Long.compare(a[1], b[1])
        );
        long[] dist = new long[26];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new long[]{src, 0});
        while(!pq.isEmpty()) {
            long[] arr = pq.poll();
            int node = (int)arr[0];
            long d = arr[1];
            if(d > dist[node]) continue;
            for(int[] neigh : adj.get(node)) {
                int newNode = neigh[0];
                int newDist = neigh[1];
                if(d + newDist < dist[newNode]) {
                    dist[newNode] = d + newDist;
                    pq.offer(new long[]{newNode, d + newDist});
                }
            }
        }
        return dist;
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < changed.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int w = cost[i];
            adj.get(u).add(new int[]{v, w});
        }
        long[][] dist = new long[26][26];
        for(int i = 0; i < 26; i++) {
            dist[i] = dijkstra(i, adj);
        }
        long res = 0;
        for(int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if(source.charAt(i) == target.charAt(i)) continue;
            if(dist[u][v] == Long.MAX_VALUE) return -1;
            res += dist[u][v];
        }
        return res;
    }
}