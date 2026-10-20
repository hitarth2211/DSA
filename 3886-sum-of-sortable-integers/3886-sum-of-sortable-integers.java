class Solution {
    void computeLPS(int[] pattern, int[] lps) {
        int M = pattern.length;
        int len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < M) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    boolean search(int[] pat, int[] txt) {
        int N = txt.length;
        int M = pat.length;

        int[] lps = new int[M];
        computeLPS(pat, lps);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < N) {
            if (pat[j] == txt[i]) {
                i++;
                j++;
            }

            if (j == M) {
                return true; // pattern found , return true
            } else if (i < N && pat[j] != txt[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
    private boolean isRotation(int[] arr1, int[] arr2) {
        int[] text = new int[2 * arr2.length];
        System.arraycopy(arr2, 0, text , 0, arr2.length);
        System.arraycopy(arr2, 0, text, arr2.length, arr2.length);
        return search(arr1, text);
    }
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int res = 0;
        for(int k = 1; k <= n; k++) {
            if(n % k != 0) continue;
            boolean valid = true;
            for(int start = 0; start < n; start += k) {
                int[] arr1 = Arrays.copyOfRange(nums, start, start + k);
                int[] arr2 = Arrays.copyOfRange(sorted, start, start + k);
                if(!isRotation(arr1, arr2)) {
                    valid = false;
                    break;
                }
            }
            if(valid) res += k;
        }
        return res;
    }
}