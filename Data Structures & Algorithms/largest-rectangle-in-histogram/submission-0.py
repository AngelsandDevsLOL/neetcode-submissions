class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        ans = 0
        for i in range(len(heights)):
            leftmost = i
            if stack is []:
                stack.append((i, heights[i]))
                continue;
            while stack != [] and stack[-1][1] > heights[i]:
                tup = stack.pop()
                ans = max(ans, (i - tup[0]) * tup[1])
                print(str(tup[0]) + " " + str(i) + " " + str(tup[1]) + " " + str(ans))
                leftmost = tup[0]
            if stack != [] and stack[-1][1] == heights[i]:
                continue
            stack.append((leftmost, heights[i]))
        while stack != []:
            tup = stack.pop()
            ans = max((len(heights) - tup[0]) * tup[1], ans)
            print(str(tup[0]) + " " + str(i) + " " + str(tup[1]) + " " + str(ans))
        return ans