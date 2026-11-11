class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long res = 0;
        if(cost1 + cost2 > costBoth) {
            int minNeed = Math.min(need1, need2);
            res += (long)minNeed * costBoth;
            need1 -= minNeed;
            need2 -= minNeed;
            if(need1 > 0) {
                res += (long)need1 * Math.min(cost1, costBoth);
            }
            else if(need2 > 0) {
                res += (long)need2 * Math.min(cost2, costBoth);
            }
        }  
        else {
            res += (long) cost1 * need1 + (long) cost2 * need2;
        }
        return res;
    }
}