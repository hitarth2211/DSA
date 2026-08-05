class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            set.add(i);
        }
        for(int[] arr: invocations) {
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k);
        set.remove(k);
        while(!q.isEmpty()) {
            int node = q.poll();
            if(visited[node]) continue;
            visited[node] = true;
            for(int next: adj.get(node)) {
                if(!visited[next]){
                    q.offer(next);
                    set.remove(next);
                }
            }
        }
        for(int[] edge: invocations) {
            int u = edge[0];
            int v = edge[1];
            // non-suspicious -> suspicious 
            if(!visited[u] && visited[v]) {
                List<Integer> res = new ArrayList<>();
                for(int i = 0; i < n; i++) res.add(i);
                return res;
            }
        }
        return new ArrayList<>(set);
    }
}