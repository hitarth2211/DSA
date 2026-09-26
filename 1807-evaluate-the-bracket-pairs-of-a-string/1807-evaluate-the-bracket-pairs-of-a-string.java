class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder res = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        for(List<String> str : knowledge) {
            String key = str.get(0);
            String val = str.get(1);
            map.put(key, val);
        }
        int n = s.length();
        int i = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(ch == '(') {
                i++;
                StringBuilder sb = new StringBuilder();
                while(s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                    i++;
                }
                String str = sb.toString();
                if(map.containsKey(str)) {
                    res.append(map.get(str));
                }
                else res.append('?');
            }
            else res.append(ch);
            i++;
        }
        return res.toString();
    }
}