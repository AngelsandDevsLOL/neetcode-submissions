class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3):
            return False
        
        dp = {}
        def interleaveHelper(x: int, y: int) -> bool:
            if (x == len(s1)) and y == len(s2):
                return True
            if (x, y) in dp:
                return dp[(x, y)]
            if y != len(s2):
                if s2[y] == s3[x + y]:
                    if interleaveHelper(x, y + 1):
                        dp[(x, y)] = True
                        return True
            if x != len(s1):
                if s1[x] == s3[x + y]:
                    if interleaveHelper(x + 1, y):
                        dp[(x, y)] = True
                        return True
            dp[(x, y)] = False
            return False
                

        return interleaveHelper(0, 0)