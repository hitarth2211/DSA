class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{-1, 0},{0, -1},{1, 0},{0, 1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        pq.offer(new int[]{0, 0, grid[0][0] == 0 ? 0 : 1});
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int r = arr[0];
            int c = arr[1];
            int obs = arr[2];
            if(r == m - 1 && c == n - 1) return obs;
            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;
                int newObs = obs + grid[nr][nc];
                if(dist[nr][nc] > newObs){
                    dist[nr][nc] = newObs;
                    pq.offer(new int[]{nr, nc, newObs});
                }
            }
        }
        return -1;
    }
}