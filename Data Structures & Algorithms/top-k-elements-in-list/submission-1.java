class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int num : nums) {
            if (hMap.containsKey(num)) {
                hMap.put(num, hMap.get(num) + 1);
            } else {
                hMap.put(num, 1);
            }
        }
        List<Integer> l = new ArrayList<>(hMap.keySet());
        l.sort((a, b) -> {
            return hMap.get(b) - hMap.get(a);
        });
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = l.get(i);
        }
        return ret;
    }
}
