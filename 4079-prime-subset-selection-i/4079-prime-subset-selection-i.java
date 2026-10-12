class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        int sum = 0;
        sieve[0] = sieve[1] = false;
        for(int i = 2; i * i <= n; i++) {
            if(sieve[i]){
            for(int j = i * i; j <= n; j += i) {
                    sieve[j] = false;
                }   
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(sieve[i] && sum + i <= s) {
                sum += i;
                res.add(i);
            }
            else if (sum + i > s) break;
        }
        return res;
    }
}