class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int cur = target - nums[i];
            if (hMap.containsKey(cur)) {
                return new int[]{hMap.get(cur), i};
            }
            hMap.put(nums[i], i);
        }
        return null;
    }
}
