class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        int[] dist = new int[n];
        int res = -1;
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b)-> Integer.compare(a[1], b[1])
            );
            pq.offer(new int[]{i, 0});
            
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            while(!pq.isEmpty()) {
                int[] arr = pq.poll();
                int node = arr[0];
                int d = arr[1];
                if(d > distanceThreshold) break;
                if(d > dist[node]) continue;
                for(int[] neigh : adj.get(node)) {
                    int newNode = neigh[0];
                    int newDist = neigh[1];
                    if(d + newDist < dist[newNode]) {
                        dist[newNode] = d + newDist;
                        pq.offer(new int[]{newNode, d + newDist});
                    }
                }
            }
            int count = 0;
            for(int d : dist) 
                if(d <= distanceThreshold) count++;
            count--; // dont count city itself 
            if(count <= minCount){
                minCount = count;
                res = i;
            }
        }
        return res;
    }
}