class Solution {
    private int dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        if(visited[node]) return 0;
        visited[node] = true;
        int size = 1;
        for(int neigh : adj.get(node)) {
            size += dfs(neigh, adj, visited);
        }
        return size;
    } 
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        long res = 0;
        boolean[] visited = new boolean[n];
        int remaining = n;
        for(int i = 0; i < n; i++){
            int size = dfs(i, adj, visited);
            remaining -= size;
            res += (long) size * remaining;
        }
        return res;
    }
}