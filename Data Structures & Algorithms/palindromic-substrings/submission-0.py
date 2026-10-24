class Solution:
    def countSubstrings(self, s: str) -> int:
        ans = {"": (0, True)}

        def dp (s: str) -> int:
            nonlocal ans
            if s in ans:
                return ans[s][0]
            elif len(s) == 1:
                ans[s] = (1, True)
                return 1
            
            substr = s[1:len(s)-1]
            l = s[1:]
            r = s[:len(s)-1]
            val = -dp(substr)
            val += dp(l)
            val += dp(r)

            if ans[substr][1] and s[0] == s[len(s) - 1]:
                ans[s] = (val + 1, True)
            else:
                ans[s] = (val, False)
            
            return ans[s][0]
            

        return dp(s)
        