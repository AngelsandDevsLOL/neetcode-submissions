class Solution {
    public static int binarySearch (int[] ar, int find, int l, int r) {
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ar[mid] <= find) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    public int[] twoSum(int[] numbers, int target) {
        int prev = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int find = target - numbers[i];
            int val = (binarySearch(numbers, find, i + 1, prev));
            if (numbers[val] == find) {
                return new int[]{i + 1, val + 1};
            }
            prev = val;
        }
        return new int[]{};
    }
}
