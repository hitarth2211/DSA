class Solution {
    public String removeOuterParentheses(String s) {
        if(s.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        int count = 0, n = s.length(), flag = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            sb.append(ch);
            if(ch == '(') count++;
            else count--;
            if(count == 0 && sb.length() != 0) {
                sb.deleteCharAt(flag);
                sb.deleteCharAt(sb.length() - 1);
                flag = sb.length();
            }
        }
        return sb.toString();
    }
}