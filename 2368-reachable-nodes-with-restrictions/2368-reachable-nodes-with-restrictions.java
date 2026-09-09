class Solution {
    private void dfs(int node, Set<Integer> set, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for(int neigh: adj.get(node)) {
            if(set.contains(neigh)) continue;
            else if(!vis[neigh]) {
                dfs(neigh, set, adj, vis);
            }
        }
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        for(int x: restricted) set.add(x);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] vis= new boolean[n];
        dfs(0, set, adj, vis);
        int res = 0;
        for(boolean x: vis) if(x) res++;
        return res;
    }
}