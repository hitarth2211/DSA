class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n = prices.length;
        int m = discounts.length;
        double[] discountPrice = new double[n];
        for(int i = 0; i < n; i++) {
            discountPrice[i] = (double) prices[i];
        }
        Arrays.sort(discountPrice);
        Arrays.sort(discounts);
        int j = m - 1;
        for(int i = n - 1; i >= 0; i--) {
            if(j >= 0) {
                discountPrice[i] = (discountPrice[i] * (100 - discounts[j])) / 100;
            }
            j--;
        }
        double res = 0;
        for(double x : discountPrice) res += x;
        return res;
    }
}