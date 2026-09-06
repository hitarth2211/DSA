class Solution {
    int[][] dirs = {{0,-1},{1,0},{-1,0},{0,1}};
    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[4], b[4])
        );
        pq.offer(new int[]{0, 0, 4, 0, grid[0][0]});
        int[][][][] dist = new int[m][n][5][k + 1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int d = 0; d < 5; d++) {
                    Arrays.fill(dist[i][j][d], Integer.MAX_VALUE);
                }
            }
        }
        dist[0][0][4][0] = grid[0][0];
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            
            int i = arr[0];
            int j = arr[1];
            int dir = arr[2];
            int turns = arr[3];
            int cost = arr[4];
            
            if(cost > dist[i][j][dir][turns]) continue;
            if(i == m-1 && j == n-1) return cost;
            for(int d = 0; d < 4; d++) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if(ni < 0 || ni >= m || nj < 0 || nj >= n)
                    continue;
                int newTurns = turns;
                if(dir != 4 && dir != d) {
                    newTurns++;
                }
                if(newTurns > k) continue;
                int newCost = cost + grid[ni][nj];
                if(newCost < dist[ni][nj][d][newTurns]) {
                    dist[ni][nj][d][newTurns] = newCost;
                    pq.offer(new int[]{ni, nj, d, newTurns, newCost});   
                }
            }
        }
        return -1;
    }
}