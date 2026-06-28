class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums.sort()
        prev = -1e9 - 2
        cur_len = 0
        max_len = 0
        for i in range(len(nums)):
            if prev == nums[i]:
                continue
            elif prev + 1 == nums[i]:
                cur_len += 1
            else:
                max_len = max(max_len, cur_len)
                cur_len = 1
            prev = nums[i]
        return max(max_len, cur_len)