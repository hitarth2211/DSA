class Solution {
    public int totalNumbers(int[] digits) {
        boolean[] vis = new boolean[1000];
        int n = digits.length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            int d = digits[i];
            if(d == 0) continue;
            for(int j = 0; j < n; j++) {
                if(j == i) continue;
                for(int k = 0; k < n; k++) {
                    if(k == i || k == j || digits[k] % 2 != 0) continue;
                    int x = 100 * digits[i] + 10 * digits[j] + digits[k];
                    if(!vis[x]) {
                        vis[x] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}