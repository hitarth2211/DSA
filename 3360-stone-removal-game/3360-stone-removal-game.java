class Solution {
    public boolean canAliceWin(int n) {
        // turn = 0 for alice and 1 for bob
        int turn = 1, stones = 10;
        while(n >= stones) {
            turn = (turn == 0) ? 1 : 0;
            n -= stones;
            stones--;
        }
        if(turn == 0) return true;
        return false;
    }
}