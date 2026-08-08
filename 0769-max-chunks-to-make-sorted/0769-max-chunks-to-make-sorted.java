class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int x : arr) {
            int max = x;
            while(!st.isEmpty() && st.peek() > x) {
                max = Math.max(max, st.pop());
            }
            st.push(max);
        }
        return st.size();
    }
}