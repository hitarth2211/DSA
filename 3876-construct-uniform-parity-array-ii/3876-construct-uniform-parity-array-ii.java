class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd=Integer.MAX_VALUE;
        boolean hasOdd=false;
        for(int n:nums1){
            if(n%2==1){
                hasOdd=true;
                minOdd=Math.min(n,minOdd);   
            }
        }
        if(!hasOdd) return true;

        for(int n:nums1){
            if(n%2==0){
                if(n<=minOdd){
                    return false;
                }
            }
        }
        return true;
    }
}