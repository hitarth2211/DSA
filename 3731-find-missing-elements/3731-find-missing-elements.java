class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int min = 101, max = 0;
        for(int x : nums) {
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        int[] elements = new int[max + 1];
        for(int x : nums) {
            elements[x] = 1;
        }
        for(int i = min; i < max; i++) {
            if(elements[i] != 1) res.add(i);
        }
        return res;
    }
}