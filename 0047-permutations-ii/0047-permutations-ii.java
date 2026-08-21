class Solution {
    List<List<Integer>> res;
    private void backtrack(int[] nums, int idx, List<Integer> temp, HashSet<List<Integer>> set, boolean[] vis) {
        if(temp.size() == nums.length) {
            if(!set.contains(temp)) {
                set.add(new ArrayList<>(temp));
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!vis[i]) {
                vis[i] = true;
                temp.add(nums[i]);
                backtrack(nums, i, temp, set, vis);
                temp.remove(temp.size() - 1);
                vis[i] = false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backtrack(nums, 0, temp, set, vis);
        return res;
    }
}