class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a[2],b[2])
        );
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int[][][] dist = new int[m][n][2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) 
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
        }
        dist[0][0][0] = 0;
        pq.offer(new int[]{0, 0, 0, 1});
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int r = arr[0];
            int c = arr[1];
            int time = arr[2];
            int cost = arr[3];
            int parity = (cost == 1) ? 0 : 1;
            if(time > dist[r][c][parity]) continue;
            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newTime = Math.max(time, moveTime[nr][nc]) + cost;
                    int nextCost = (cost == 1) ? 2 : 1;
                    int nextParity = (nextCost == 1) ? 0 : 1; 
                    if(newTime < dist[nr][nc][nextParity]) {
                        dist[nr][nc][nextParity] = newTime;
                        pq.offer(new int[]{nr, nc, newTime, nextCost});
                    }
                }
            }
        }
        return Math.min(dist[m - 1][n - 1][0],
                dist[m - 1][n - 1][1]);
    }
}