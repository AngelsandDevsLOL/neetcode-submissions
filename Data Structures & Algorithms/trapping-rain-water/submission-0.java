class Solution {
    public int trap(int[] height) {
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];

        int ans = 0;
        lMax[0] = height[0];
        rMax[height.length - 1] = height[height.length - 1]; 
        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
            rMax[height.length - i - 1] = Math.max(rMax[height.length - i], height[height.length - i - 1]);
        }
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return ans;
    }
}
