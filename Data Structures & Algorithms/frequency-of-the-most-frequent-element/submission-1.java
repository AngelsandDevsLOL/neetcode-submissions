class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int[] psa = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            psa[i + 1] = psa[i] + nums[i];
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, bSearch(psa, k, 1, i + 1) + 1);
        }
        return max;
    }
    public int bSearch(int[] psa, int find, int l, int r) { // [l, r)
        int ans = r;
        int val = r;
        while (l < r) {
            int mid = (l + r) / 2;
            // System.out.println("checking " + mid + " " + find + " " + r + " " + meth(psa, mid, val));
            if (meth(psa, mid, val) <= find) { // interval from [mid, r)
                ans = mid; r = mid;
                // System.out.println("yay " + mid + " " + find + " " + r);
            } else {
                l = mid + 1;
            }
        }
        // System.out.println("final " + ans + " " + val);
        return val - ans;
    }
    public int meth (int[] psa, int ind, int r) {
        return (psa[r] - psa[r-1]) * (r - ind) - (psa[r - 1] - psa[ind - 1]);
    }
}