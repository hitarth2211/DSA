class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        Map<Integer, LinkedList<Integer>> groups = new HashMap<>();
        Map<Integer, Integer> oriToGroup = new HashMap<>();
        int counter = 0;
        groups.put(counter, new LinkedList<>());
        groups.get(counter).add(copy[0]);
        oriToGroup.put(copy[0], counter);
        for(int i = 1; i < n; i++) {
            if(copy[i] - copy[i - 1] <= limit) {
                groups.get(counter).add(copy[i]);  
            }
            else {
                counter++;
                groups.put(counter, new LinkedList<>());
                groups.get(counter).add(copy[i]);
            }
            oriToGroup.put(copy[i], counter);
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            int group = oriToGroup.get(num);
            res[i] = groups.get(group).pollFirst();
        }
        return res;
    }
}