class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;
        int res = n;
        int currSpeed = speed[n - 1];
        for(int i = n - 1; i > 0; i--) {
            if(speed[i - 1] > currSpeed || position[i] - position[i - 1] <= distance) {
                res--;
            } 
            else currSpeed = speed[i - 1];
        }
        return res;
    }
}