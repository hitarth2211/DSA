class Solution {
    private long power(long a, long b, long mod) {
        long pow = 1;
        while(b > 0) {
            if((b & 1) == 1) {
                pow = (pow * a) % mod;
                b /= 1;
            }
            a = (a * a) % mod;
            b /= 2;
        }
        return pow;
    }
    public int sumDecoded(long[] nums) {
        long res = 0, n = nums.length, mod = 1000000007;
        for(int i = 0; i < n; i++) {
            long num = nums[i];
            long width = nums[i] % 10;
            long d = (long)Math.floor(num / 10);
            String str = Long.toString(d);
            String x = str.substring(0, (int)width);
            String y = str.substring((int)width, str.length());
            long a = Long.parseLong(x);
            long b = Long.parseLong(y);
            long pow = power(a, b , mod);
            res = (res + pow) % mod; 
        }
        return (int)res;
    }
}