class Solution {
    public int minimumPushes(String word) {
        // PriorityQueue<int[]> pq = new PriorityQueue<>(
        //     (a,b)->Integer.compare(b[1],a[1])
        // );
        // int[] freq = new int[26];
        // for(int i = 0; i < word.length(); i++) {
        //     char ch = word.charAt(i);
        //     freq[ch - 'a']++;
        // }
        // for(int i = 0; i < 26; i++) {
        //     pq.add(new int[]{i, freq[i]});
        // }
        // int res = 0, count = 1, idx = 2;
        // while(!pq.isEmpty()) {
        //     int[] arr = pq.poll();
        //     char ch = (char)(arr[0] + 'a');
        //     int fre = arr[1];
        //     res += count * fre;
        //     if(idx == 9){
        //         idx = 2;
        //         count++; 
        //     }
        //     else idx++;
        // }
        // return res;


        int[] freq = new int[26];
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int res = 0, idx = 2, count = 1;
        for(int i = 25; i >= 0; i--) {
            res += freq[i] * count;
            if(idx == 9) {
                idx = 2;
                count++;
            }
            else idx++;
        }
        return res;
    }
}