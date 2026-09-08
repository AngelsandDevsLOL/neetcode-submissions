class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        nums.sort()
        
        def bSearch(nums: List[int], l: int, r: int) -> int:
            while l <= r:
                mid = (l + r) // 2
                if nums[mid] <= 0:
                    l = mid + 1
                else:
                    r = mid - 1
            return l

        ind = bSearch(nums, 0, len(nums) - 1)
        check = 1
        for i in range(ind, len(nums)):
            if nums[i] == check:
                check += 1
            elif nums[i] == check - 1:
                continue
            else:
                return check
        return check