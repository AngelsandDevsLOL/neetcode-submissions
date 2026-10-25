class Solution:
    def partition(self, s: str) -> List[List[str]]:
        dp = {len(s): [[""]]}
        palindrome = {}
        def isPalin(x: str) -> bool:
            if len(x) <= 1:
                return True
            elif x in palindrome:
                return palindrome[x]
            palindrome[x] = (x[0] == x[len(x) - 1]) and isPalin(x[1:len(x)-1])
            return palindrome[x]
        def palin(x: int) -> List[List[str]]:
            nonlocal dp
            nonlocal s
            if x in dp:
                return dp[x]          
            ret = []
            for i in range(x + 1, len(s) + 1):
                tmp = s[x:i]
                print(tmp)
                if isPalin(tmp):
                    second = s[i:]
                    print(f'second: {second}')
                    add = palin(i)
                    if add == [[""]]:
                        ret += [[tmp]]
                    else:
                        ret += [[tmp] + add[j] for j in range(len(add))]
            dp[x] = ret
            return dp[x]

        palin(0)
        return dp[0]