class Solution {
    long mod = 1000000007;
    long[][] PT;
    private int solve(List<Integer> list) {
        int n = list.size();
        if(n < 3) return 1;
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();
        int root = list.get(0);
        for(int i = 1; i < n; i++) {
            if(list.get(i) < root) leftArray.add(list.get(i));
            else rightArray.add(list.get(i));
        }
        long x = solve(leftArray) % mod;
        long y = solve(rightArray) % mod;
        long z = PT[n - 1][leftArray.size()];
        return (int)((((x * y) % mod) * z) % mod);
    }
    public int numOfWays(int[] nums) {
        int n = nums.length;
        PT = new long[n + 1][];
        for(int i = 0; i <= n; i++) {
            PT[i] = new long[i + 1];
            Arrays.fill(PT[i], 1);
            for(int j = 1; j < i; j++) {
                PT[i][j] = (PT[i - 1][j] + PT[i - 1][ j - 1]) % mod;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int x: nums) list.add(x);
        return (int)((solve(list) - 1) % mod);    
    }
}