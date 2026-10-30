class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[] {v, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        pq.offer(new int[]{0, 0, 1});
        int[][] dist = new int[n][k + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][1] = 0;
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int node = arr[0];
            int cost = arr[1];
            int count = arr[2];
            if(dist[node][count] < cost) continue;
            if(node == n - 1) return cost;
            for(int[] neigh: adj.get(node)) {
                int nei = neigh[0];
                int w = neigh[1];
                int newCount = (labels.charAt(node)) == (labels.charAt(nei)) ? count + 1 : 1;
                if(newCount <= k && dist[nei][newCount] > cost + w) {
                    dist[nei][newCount] = cost + w;
                    pq.offer(new int[]{nei, cost + w, newCount});
                } 
            }
        }
        return -1;
    }
}