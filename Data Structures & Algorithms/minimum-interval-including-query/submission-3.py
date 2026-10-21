class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        # loop through each interval, calculate value (right - left) and starting position and ending position, where we let ending position be ending + 1
        # dictionary (value, # of intervals with value)
        # keep a priority queue of (index, add or remove value), sorted by index
        # sort query, keep a map of [original index, query value]
        # go through pq until query val < nextVal

        pq = []
        dictionary = {} # (value, # of intervals w/ val)
        for interval in intervals:
            val = interval[1] - interval[0] + 1
            heapq.heappush(pq, (interval[0], val))
            heapq.heappush(pq, (interval[1] + 1, -val))
        sortedQ = []
        for i, query in enumerate(queries):
            sortedQ += [[query, i]]

        sortedQ.sort()
        pointer = 0
        ans = [-1] * len(queries)

        while pq and pointer < len(queries):
            cur = pq[0]
            while pq and pq[0][0] <= sortedQ[pointer][0]:
                cur = heapq.heappop(pq)
                if cur[1] > 0:
                    dictionary[cur[1]] = dictionary.get(cur[1], 0) + 1
                elif dictionary[-cur[1]] == 1:
                    dictionary.pop(-cur[1])
                else:
                    dictionary[-cur[1]] = dictionary.get(-cur[1]) - 1
            
            if dictionary:
                ans[sortedQ[pointer][1]] = min(dictionary)
            if not pq:
                break
            
            
            pointer += 1
        return ans