class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a[2],b[2])
        );
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int r = arr[0];
            int c = arr[1];
            int time = arr[2];
            if(time > dist[r][c]) continue;
            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newTime = Math.max(time, moveTime[nr][nc]) + 1;
                    if(newTime < dist[nr][nc]) {
                        dist[nr][nc] = newTime;
                        pq.offer(new int[]{nr, nc, newTime});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}