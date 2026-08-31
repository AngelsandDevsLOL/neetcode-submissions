class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def bSearch(nums: List[int], l: int, r: int, target: int) -> int:
            ans = -1;
            while l <= r:
                m = (l + r) // 2
                if nums[m] <= target: 
                    l = m + 1
                    ans = m
                else:
                    r = m - 1
                
            return ans

        def bSearch2(nums: List[int], l: int, r: int, target: int) -> int:
            ans = -1;
            while l <= r:
                m = (l + r) // 2
                if nums[m] < target:
                    l = m + 1
                else:
                    r = m - 1
                    ans = m
                
            return ans
        right = bSearch(nums, 0, len(nums) - 1, target)
        left = bSearch2(nums, 0, len(nums) - 1, target)

        if left == -1 or nums[left] != target:
            return [-1, -1]
        return [left, right]