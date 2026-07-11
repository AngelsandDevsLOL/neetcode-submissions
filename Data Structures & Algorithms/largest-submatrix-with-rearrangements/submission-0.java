class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int[] sum = new int[matrix[0].length];
        int ret = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    sum[j] -= 1;
                } else sum[j] = 0;
            }
            int[] tmp = sum.clone();
            Arrays.sort(tmp);
            for (int j = 0; j < matrix[0].length; j++) {
                ret = Math.max(ret, tmp[j] * (j + 1) * -1);
            }
        }
        return ret;
    }
}