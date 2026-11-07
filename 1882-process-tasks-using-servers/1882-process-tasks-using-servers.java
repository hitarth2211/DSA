class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;
        PriorityQueue<int[]> freeServers = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        );
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
                if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[2], b[2]);
            }
        );
        int[] res = new int[m];
        for(int i = 0; i < n; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }
        for(int i = 0; i < m; i++) {
            while(!busyServers.isEmpty() && busyServers.peek()[0] <= i) {
                int[] curr = busyServers.poll();
                freeServers.offer(new int[]{curr[1], curr[2]});
            }
            if(freeServers.isEmpty()) {
                int[] curr = busyServers.poll();
                res[i] = curr[2];
                busyServers.offer(new int[]{curr[0] + tasks[i], curr[1], curr[2]});
            }
            else {
                int[] curr = freeServers.poll();
                res[i] = curr[1];
                busyServers.offer(new int[]{i + tasks[i], curr[0], curr[1]});
            }
        }
        return res;
    }
}