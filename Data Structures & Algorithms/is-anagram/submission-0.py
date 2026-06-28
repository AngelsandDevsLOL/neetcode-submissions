class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dict1 = {}
        dict2 = {}
        for i in s:
            if i not in dict1:
                dict1[i] = 0
            dict1[i] += 1
        for i in t:
            if i not in dict2:
                dict2[i] = 0
            dict2[i] += 1
        if len(dict1) != len(dict2): 
            return False
        return dict1 == dict2