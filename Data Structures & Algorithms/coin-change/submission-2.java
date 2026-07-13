class Solution {
    public HashMap<Integer, Integer> smallest = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (smallest.containsKey(amount)) return smallest.get(amount);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount < coins[i]) continue;
            int num = coinChange(coins, amount - coins[i]);
            if (num != -1) min = Math.min(min, 1 + num);
        }   
        if (min == Integer.MAX_VALUE) {smallest.put(amount, -1); return -1;}
        smallest.put(amount, min);
        return min;
    }
}
