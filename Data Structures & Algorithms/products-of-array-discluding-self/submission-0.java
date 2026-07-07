class Solution {
    public int[] productExceptSelf(int[] nums) {
        long accumulator = 1;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++;
            else accumulator *= nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zeros == 1) ans[i] = (int) accumulator;
            else if (zeros == 0) ans[i] = (int) (accumulator / nums[i]);
            else ans[i] = 0;
        }
        return ans;
    }
}  
