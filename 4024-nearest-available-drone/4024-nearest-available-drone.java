class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int res = Integer.MAX_VALUE, min =  Integer.MAX_VALUE;
        for(int i = 0; i < drones.length; i++) {
            int x = drones[i][0];
            int y = drones[i][1];
            int range = drones[i][2];
            int tx = target[0];
            int ty = target[1];
            int dist = Math.abs(x - tx) + Math.abs(y - ty);
            if(dist <= range && dist < min) {
                min = dist;
                res = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : res;
    }
}