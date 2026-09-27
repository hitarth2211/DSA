class Solution {
    private void reverse(StringBuilder sb , int start, int end) {
        while(start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--; 
        }
    }
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.add(res.length());
            }
            else if(ch == ')') {
                int start = st.pop();
                reverse(res, start, res.length() - 1); 
            }
            else res.append(ch);
        }
        return res.toString();
    }
}