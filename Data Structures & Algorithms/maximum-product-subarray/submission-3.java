class Solution {
    public int maxProduct(int[] nums) {
        HashSet<Integer> neg = new HashSet<>();
        int zeroes = 0;
        long total = 1;
        int max = Integer.MIN_VALUE;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) neg.add(i);
            if (nums[i] == 0) {
                max = Math.max(max, met(nums, neg, prev, i)); // [prev, i)
                prev = i + 1;
                zeroes++;
                neg = new HashSet<>();
            }
        }
        if (prev == 0) return max = met(nums, neg, 0, nums.length);
        return Math.max(Math.max(0, met(nums, neg, prev, nums.length)), max);
    }
    public int met (int[] nums, HashSet<Integer> neg, int l, int r) { // guaranteed no zeros!
        if (l == r) return Integer.MIN_VALUE; //nothing
        if (l + 1 == r) return nums[l];
        long prod = 1;
        for (int i = l; i < r; i++) {
            prod *= nums[i];
        }
        long left = 1;
        for (int i = l; i < r; i++) {
            left *= nums[i];
            if (nums[i] < 0) break;
        }
        long right = 1;
        for (int i = r - 1; i >= l; i--) {
            right *= nums[i];
            if (nums[i] < 0) break;
        }
        if (neg.size() % 2 == 0) return (int) prod;
        else return (int) (prod / Math.max(left, right));
    }
}
