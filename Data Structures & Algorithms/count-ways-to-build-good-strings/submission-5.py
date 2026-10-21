class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        dp = [0] * (high + 1)
        dp[0] = 1
        ret = 0;
        for i in range(1, high + 1):
            if i >= zero:
                dp[i] += dp[i - zero]
            if i >= one:
                dp[i] += dp[i - one]
            if i >= low:
                ret += dp[i]
                ret %= 1e9+7
            dp[i] %= 1e9+7
        return int(ret)