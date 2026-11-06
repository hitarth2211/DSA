class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;
        int[] res = new int[queries.length];
        List<int[]> q = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        for(int i = 0; i < queries.length; i++) {
            q.add(new int[]{queries[i], i});
        }
        Collections.sort(q, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, j = 0; 
        for(int[] query : q) {
            int idx = query[1];
            int time = query[0];
            int start = time - x;
            int end = query[0];

            while(j < m && logs[j][1] <= end) {
                map.put(logs[j][0], map.getOrDefault(logs[j][0], 0) + 1);
                j++;
            }
            while(i < m && logs[i][1] < start) {
                map.put(logs[i][0], map.getOrDefault(logs[i][0], 0) - 1);
                if(map.get(logs[i][0]) == 0) map.remove(logs[i][0]);
                i++;
            }
            res[idx] = n - map.size();
        }
        return res;
    }
}