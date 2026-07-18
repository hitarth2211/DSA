class Solution {
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int min = 1001;
        int max = 1;
        for(int n : nums) {
            min = Math.min(n, min);
            max = Math.max(n, max);
        }
        return gcd(min, max);
    }
}