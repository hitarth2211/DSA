class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        long res = 0;
        int n = parent.length;
        int m = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }
        int[] depth = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        depth[0] = 1;
        int height = 1;
        q.offer(0);
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int child : adj.get(node)) {
                depth[child] = depth[node] + 1;
                height = Math.max(height, depth[child]);
                q.offer(child);
            }
        }
        for(int i = 0; i < n; i++) {
            res += (long) nums[i] * (height - depth[i] + 1);
        }
        return res;
    }
}