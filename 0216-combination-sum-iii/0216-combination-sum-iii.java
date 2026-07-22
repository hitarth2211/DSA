class Solution {
    List<List<Integer>> res = new ArrayList<>();
    private void backtrack(int k, int n, int sum, int start, List<Integer> temp, Set<Integer> set) {
        if(temp.size() == k && sum == n) {
            res.add(new ArrayList<>(temp));
        }
        for(int i = start + 1; i <= 9; i++) {
            if(!set.contains(i)){
                temp.add(i);
                set.add(i);
                backtrack(k, n, sum + i, i, temp, set);
                set.remove(i);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        backtrack(k, n, 0, 0, temp, set);
        return res;
    }
}