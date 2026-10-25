class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3):
            return False
        
        dp = [[False] * (len(s2) + 1) for _ in range(len(s1) + 1)]
        dp[len(s1)][len(s2)] = True;
        for i in range(len(s2) - 1, -1, -1):
            dp[len(s1)][i] = dp[len(s1)][i + 1] and s2[i] == s3[i + len(s1)]
        for i in range(len(s1) - 1, -1, -1):
            dp[i][len(s2)] = dp[i + 1][len(s2)] and s1[i] == s3[i + len(s2)]
            for j in range(len(s2) - 1, -1, -1):
                dp[i][j] = (dp[i + 1][j] and s1[i] == s3[i + j]) or (dp[i][j + 1] and s2[j] == s3[i + j]) 
        return dp[0][0]