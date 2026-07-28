class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            freq[idx]++;
        }
        StringBuilder sb = new StringBuilder();
        int middle = 0;
        for(int i = 0; i < 26; i++) {
            if(freq[i] % 2 == 1) middle = i;
            int size = freq[i];
            int half = size / 2;
            char ch = (char)(i + 'a');
            for(int j = 0; j < half; j++){
                sb.append(ch);
            }
        }
        String first = sb.toString();
        String reverse =  new StringBuilder(first).reverse().toString();
        if(freq[middle] % 2 == 1) 
            sb.append((char)(middle + 'a'));
        sb.append(reverse);
        return sb.toString();
        
    }
}