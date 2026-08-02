class Solution {
    int[][] memo;
    private int solve (int i, int j, int[] piles) {
        if(i > j) return 0;
        
        if(i == j) return piles[i];

        if(memo[i][j] != -1) {
           return  memo[i][j];
        }

        int take_i = piles[i] + Math.min(solve(i + 2, j , piles),solve(i + 1, j - 1, piles));
    
        int take_j = piles[j] + Math.min(solve(i + 1, j - 1, piles),solve(i, j - 2, piles));

        return memo[i][j] = Math.max(take_i, take_j);
    }

    public boolean stoneGame(int[] piles) {
       
        // greedy approach (wrong answer)
        // int[]alice=new int[piles.length/2];
        // int[]bob=new int[piles.length/2];
        // int left=0,right=piles.length-1;
        // int a=0,b=0;
        // for(int i=0;i<piles.length&&left<right;i++){
        //     if(i%2==0){
        //         if(piles[left]>piles[right]){
        //             alice[a++]=piles[left];
        //             left++;
        //         }
        //         else{
        //             alice[a++]=piles[right];
        //             right--;
        //         }
        //     }
        //     else{
        //         if(piles[left]>piles[right]){
        //             bob[b++]=piles[left];
        //             left++;
        //         }
        //         else{
        //             bob[b++]=piles[right];
        //             right--;
        //         }
        //     }
        // }
        // int sum1=0,sum2=0;
        // for(int i=0;i<alice.length;i++){
        //     sum1+=alice[i];
        //     sum2+=bob[i];
        // }
        // return sum1>sum2;


        // 2nd solution
        // either alice takes even index sum or odd index sum   (maximum of both) and forces bob to take other index sum  
        // return true;


        //3rd solution recursion + memo
        int total = 0, n = piles.length;
        memo = new int[n][n];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        for(int x : piles) total += x;
        int aliceScore = solve(0, n - 1, piles);
        int bobScore = total - aliceScore;
        return aliceScore >= bobScore;
        
    }
}