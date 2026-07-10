class Solution {
    public int subsetXORSum(int[] nums) {
        return recur(0, nums, 0);
    }
    public int recur(int index, int[] nums, int total) {
        if (index == nums.length) return total;
        return recur(index + 1, nums, total) + recur(index + 1, nums, total ^ nums[index]);
    }
}