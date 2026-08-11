class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adj.get(from).add(new int[]{to, price});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1],b[1])
        );
        int[][] dist = new int[n][k + 2];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[src][0] = 0;
        pq.offer(new int[]{src, 0, 0});
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int city = arr[0];
            int price = arr[1];
            int curr = arr[2];
            if(city == dst) return price;
            if(curr == k + 1) continue;
            if(price > dist[city][curr]) continue;
            for(int[] neigh : adj.get(city)) {
                int newCity = neigh[0];
                int newPrice = neigh[1];
                int newCurr = curr + 1;
                if(price + newPrice < dist[newCity][newCurr]) {
                    dist[newCity][newCurr] = price + newPrice;
                    pq.offer(new int[]{newCity, price + newPrice, newCurr});
                }
            }
        }
        return  -1;
    }
}