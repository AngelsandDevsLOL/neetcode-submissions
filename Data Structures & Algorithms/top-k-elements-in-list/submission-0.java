class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[][] freq = new int[2001][2];
        for (int num : nums) {
            freq[num + 1000][0]++;
        }
        for (int i = 0; i < 2001; i++) {
            freq[i][1] = i - 1000;
        }
        Arrays.sort(freq, (x, y) -> {
            return Integer.compare(x[0], y[0]);
        });
        int[] ret = new int[k];
        for (int j = 0; j < k; j++) {
           ret[j] = freq[2000 - j][1]; 
        }
        return ret;
    }
}
