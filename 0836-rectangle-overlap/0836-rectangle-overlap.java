class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int p1 = rec2[0];
        int q1 = rec2[1];
        int p2 = rec2[2];
        int q2 = rec2[3];
        if(p2 > x1 && p1 < x2 && q2 > y1 && q1 < y2) return true;
        return false;
    }
}