class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depth = 0, n = seq.length();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            char ch = seq.charAt(i);
            if(ch == '(') {
                depth++;
                res[i] = depth % 2;
            }
            else{
                res[i] = depth % 2;
                depth--;
            }
        }
        return res;
    }
}