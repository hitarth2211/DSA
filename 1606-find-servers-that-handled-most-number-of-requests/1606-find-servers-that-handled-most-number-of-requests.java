class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;
        int[] serverCount = new int[k];
        int max = 0;
        List<Integer> res = new ArrayList<>();
        TreeSet<Integer> freeServers = new TreeSet<>();
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        );
        for(int i = 0; i < k; i++) freeServers.add(i);
        for(int i = 0; i < n; i++) {
            while(!busyServers.isEmpty() && busyServers.peek()[0] <= arrival[i]) {
                int[] curr = busyServers.poll();
                freeServers.add(curr[1]);
            }
            if(freeServers.size() == 0) continue;

            Integer server = freeServers.ceiling(i % k);

            if(server == null) server = freeServers.first();

            int finishTime = arrival[i] + load[i];

            serverCount[server]++;

            if(serverCount[server] > max) {
                max = serverCount[server];
                res.clear();
                res.add(server);
            } 
            else if(serverCount[server] == max) {
                res.add(server);
            }

            freeServers.remove(server);
            busyServers.offer(new int[]{finishTime, server});
        }    
        return res;
    }
}