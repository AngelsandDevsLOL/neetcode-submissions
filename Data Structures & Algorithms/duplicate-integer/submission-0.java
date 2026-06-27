class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hSet = new HashSet<Integer>();
        for (int x : nums) {
            if (hSet.contains(x)) {
                return true;
            }
            hSet.add(x);
        }
        return false;
    }
}