class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum + nums[i] > 0) r--;
                else if (sum + nums[i] < 0) l++;
                else {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]); ans.add(nums[l]); ans.add(nums[r]);
                    ans.sort(null);
                    if (!ret.contains(ans)) ret.add(ans);
                    l++; r--;
                }
            }
        }
        return ret;
    }
}
