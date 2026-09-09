class Solution {
    public long countCommas(long n) {
        long res=0;
        for(long t=1000;t<=n;t*=1000){
            res+=n-t+1;
        }
        return res;
    }
}