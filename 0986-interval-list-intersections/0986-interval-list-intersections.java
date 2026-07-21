class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int first = 0, second = 0;
        int m = firstList.length, n = secondList.length;
        List<int[]> res = new ArrayList<>();
        while(first < m && second < n) {
            int ele1 = firstList[first][0];
            int ele2 = firstList[first][1];
            int ele3 = secondList[second][0];
            int ele4 = secondList[second][1];
            int start = Math.max(ele1, ele3);
            int end = Math.min(ele2, ele4);
            if(start <= end){
                res.add(new int[]{start, end});
            }
            if(ele2 < ele4) first++;
            else second++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}