class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        treeMap = {}
        for i in range(0, len(heights)):
            treeMap[heights[i]] = names[i]
        
        dictionary = dict(sorted(treeMap.items(), reverse = True))
        return [dictionary[i] for i in dictionary]