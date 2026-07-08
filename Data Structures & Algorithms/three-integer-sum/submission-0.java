class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, HashSet<Integer>> hMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hMap.containsKey(nums[i])) hMap.get(nums[i]).add(i);
            else {
                HashSet<Integer> hSet = new HashSet<>();
                hSet.add(i);
                hMap.put(nums[i], hSet);
            }
        }
        HashSet<List<Integer>> aList = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int target = - nums[i] - nums[j];
                HashSet<Integer> h = hMap.get(target);
                if (h != null) {
                    for (int x : h) {
                        if (x > i && x > j) {
                            List<Integer> t = new ArrayList<>();
                            t.add(nums[i]); t.add(nums[j]); t.add(nums[x]);
                            t.sort(null);
                            aList.add(t);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (List<Integer> l : aList) {
            ret.add(l);
        }
        return ret;
    }
}
