class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        ret = set()
        for i in range(len(nums)):
            for j in range(i + 1, len(nums) - 1):
                find = target - nums[i] - nums[j]
                l, r = j + 1, len(nums) - 1
                while l < r:
                    if nums[l] + nums[r] == find:
                        n = [i, j, l, r]
                        l += 1
                        n.sort()
                        if len(n) != 4:
                            continue;
                        ret.add((nums[n[0]], nums[n[1]], nums[n[2]], nums[n[3]]))
                    elif nums[l] + nums[r] < find:
                        l += 1
                    else:
                        r -= 1
        ret2 = [list(i) for i in ret]
        return ret2