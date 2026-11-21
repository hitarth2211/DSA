class Solution {
    int[] position;
    int[] newParent;
    List<List<Integer>> adj;
    int n;
    int[] res;
    private int dfs1(int node, List<List<Integer>> newAdj) {
        if(node >= n) return 1;
        int count = 1;
        for(int child: newAdj.get(node)) {
            count += dfs1(child, newAdj);
        } 
        res[node] = count;
        return count;
    }
    private void dfs(int node, int[] parent, String s) {
        if(node >= n) return;
        int ch = s.charAt(node) - 'a';
        int prev = position[ch];
        if(prev != -1) {
            newParent[node] = prev;
        }
        else newParent[node] = parent[node];
        position[ch] = node;
        for(int child: adj.get(node)) {
            dfs(child, parent, s);
        }
        position[ch] = prev;
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        n = parent.length;
        res = new int[n];
        adj = new ArrayList<>();
        position = new int[26];
        newParent = new int[n];
        Arrays.fill(position, -1);
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }
        dfs(0, parent, s);
        List<List<Integer>> newAdj = new ArrayList<>();
        for(int i = 0; i < n; i++) newAdj.add(new ArrayList<>());
        for(int i = 1; i < n; i++) {
            newAdj.get(newParent[i]).add(i);
        }
        dfs1(0, newAdj);
        return res;
    }
}