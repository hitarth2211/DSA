class Solution {
    private int countOverlaps(int rowOff, int colOff, int[][] img1, int[][] img2) {
        int n = img1.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int idx_i = i + rowOff;
                int idx_j = j + colOff;
                if(idx_i < 0 || idx_i >= n || idx_j < 0 || idx_j >= n) continue;
                if(img1[i][j] == 1 && img2[idx_i][idx_j] == 1) count++;
            }
        }
        return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int res = 0;
        for(int i = -n + 1; i < n; i++) {
            for(int j = -n + 1; j < n; j++) {
                int count = countOverlaps(i, j, img1, img2);
                res = Math.max(res, count);
            }
        }
        return res;
    }
}