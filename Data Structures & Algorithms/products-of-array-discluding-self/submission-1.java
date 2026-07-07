class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftAcc = 1;
        int rightAcc = 1;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else rightAcc *= nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) rightAcc /= nums[i];
            if (nums[i] == 0) {
                if (zeros == 1) ans[i] = leftAcc * rightAcc;
            } else if (zeros == 0) {
                ans[i] = leftAcc * rightAcc;
            }
            leftAcc *= nums[i];
        }
        return ans;
    }
}  
