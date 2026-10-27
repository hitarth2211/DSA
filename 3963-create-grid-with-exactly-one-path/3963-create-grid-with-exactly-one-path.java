class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        StringBuilder top = new StringBuilder();
        StringBuilder left = new StringBuilder();
        for(int i = 0; i < n; i++) top.append('.');
        for(int i = 0; i < n - 1; i++) left.append('#');
        
        res[0] = top.toString();
        left.append('.');
        String row = left.toString();
        for(int i = 1; i < m; i++) res[i] = row;
        
        return res;
    }
}