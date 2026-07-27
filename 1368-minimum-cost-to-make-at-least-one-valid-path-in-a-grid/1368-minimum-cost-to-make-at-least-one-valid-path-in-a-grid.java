class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[2],b[2])
        );
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int r = arr[0];
            int c = arr[1];
            int cost = arr[2];
            if(cost > dist[r][c]) continue;
            for(int k = 0; k < 4; k++) {
                int nr = r + dirs[k][0];
                int nc = c + dirs[k][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int wt = (grid[r][c] == k + 1) ? 0 : 1;
                    if(cost + wt < dist[nr][nc]) {
                        dist[nr][nc] = cost + wt;
                        pq.offer(new int[]{nr, nc, cost + wt});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}