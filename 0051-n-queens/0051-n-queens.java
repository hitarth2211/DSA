class Solution {
    List<List<String>> res;
    private boolean isValid(int row, int col, List<String> board) {
        for(int i = row; i >= 0; i--) {
            if(board.get(i).charAt(col) == 'Q') 
                return false;
        }

        for(int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
            if(board.get(i).charAt(j) == 'Q') return false;
        }

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }
    private void solve(int row, List<String> board) {
        if(row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }
        for(int col = 0; col < board.size(); col++) {
            if(isValid(row, col, board)) {
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(col, 'Q');
                board.set(row, newRow.toString());

                solve(row + 1, board);

                newRow.setCharAt(col, '.');
                board.set(row, newRow.toString());
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n > 1 && n < 4) return res;
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < n; j++) {
                row.append('.');
            }
            board.add(row.toString());
        }
        solve(0, board);
        return res;
    }
}