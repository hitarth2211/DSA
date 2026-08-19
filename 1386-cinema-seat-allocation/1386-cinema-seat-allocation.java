class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>>map=new HashMap<>();
        for(int[]seat:reservedSeats){
            map.putIfAbsent(seat[0],new HashSet<>());
            map.get(seat[0]).add(seat[1]);
        }
        int res=(n-map.size())*2;
        for(int row:map.keySet()){
            Set<Integer>set=map.get(row);
            boolean left=!(set.contains(2)||set.contains(3)||set.contains(4)||set.contains(5));
            boolean right=!(set.contains(6)||set.contains(7)||set.contains(8)||set.contains(9));
            boolean middle=!(set.contains(4)||set.contains(5)||set.contains(6)||set.contains(7));
            if(left) res++;
            if(right) res++;
            if(!left&&!right&&middle) res++;
        }
        return res;
    }
}