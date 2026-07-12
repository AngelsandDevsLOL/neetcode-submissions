class Solution {
    public HashSet<Integer> h = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (h.contains(n)) return false;
        int next = 0;
        h.add(n);
        while (n != 0) {
            next += Math.pow(n % 10, 2);
            n /= 10;
        }
        return isHappy(next);
    }
}
