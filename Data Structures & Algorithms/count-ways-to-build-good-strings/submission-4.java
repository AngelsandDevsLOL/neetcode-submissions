class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        dp[0] = 1L;
        long ret = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] += dp[i - zero];
            if (i >= one) dp[i] += dp[i - one];
            if (i >= low) {
                ret += dp[i];
                ret %= (long)(1e9 + 7);
            }
            dp[i] %= (long)(1e9+7);
        }
        return (int) ret;
    }
}
