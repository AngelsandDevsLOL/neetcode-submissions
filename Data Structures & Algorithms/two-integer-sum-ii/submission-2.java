class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0; int r = numbers.length - 1;
        int sum = numbers[l] + numbers[r];
        while (l <= r) {
            if (sum < target) {
                sum -= numbers[l++];
                sum += numbers[l];
            } else if (sum > target) {
                sum -= numbers[r--];
                sum += numbers[r];
            }
            if (sum == target) return new int[]{l + 1, r + 1};
        }
        return null;
    }
}
