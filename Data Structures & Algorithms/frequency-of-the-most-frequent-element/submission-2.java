class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        // int[] psa = new int[nums.length + 1];
        // for (int i = 0; i < nums.length; i++) {
        //     psa[i + 1] = psa[i] + nums[i];
        // }
        int l = 0; int r = 1; // [l, r)
        int max = 0;
        int needed = 0;
        while (l <= r && r < nums.length) {
            int match = nums[r];
            int prev = r >= 1 ? nums[r - 1] : 0;
            needed += (match - prev) * (r - l);
            if (needed <= k) {

            } else {
                needed -= (match - nums[l]);
                l++;
            }
            r++;
        }
        return r - l;
    }
}