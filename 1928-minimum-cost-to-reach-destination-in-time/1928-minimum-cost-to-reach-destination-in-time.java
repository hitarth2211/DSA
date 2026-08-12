class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time}); 
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[2], b[2])
        );
        int[][] dist = new int[n][maxTime + 1];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = passingFees[0];
        pq.offer(new int[]{0, 0, passingFees[0]});
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int city = arr[0];
            int time = arr[1];
            int fees = arr[2];
            if(city == n - 1) return fees;
            if(time > dist[city][time]) continue;
            for(int[] neigh : adj.get(city)) {
                int next = neigh[0];
                int newTime = neigh[1] + time;
                int newFees = fees + passingFees[next];
                if(newTime <= maxTime && newTime < dist[next][newTime]) {
                    dist[next][newTime] = newTime;
                    pq.offer(new int[]{next, newTime, newFees});
                }
            }
        }
        return -1;
    }
}