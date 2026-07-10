class Solution {
    int totalSum = 0;
    public int subsetXORSum(int[] nums) {
        recur(0, nums, 0);
        return totalSum;
    }
    public void recur(int index, int[] nums, int xor) {
        if (index == nums.length) {totalSum += xor; return;}
        recur(index + 1, nums, xor);
        recur(index + 1, nums, xor ^ nums[index]);
    }
}