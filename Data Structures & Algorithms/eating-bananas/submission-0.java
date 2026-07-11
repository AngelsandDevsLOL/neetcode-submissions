class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1; int r = 1000000000;
        int ret = r;
        while (l <= r) {
            int m = (l + r) / 2;
            if (works(piles, h, m)) {
                ret = m;
                r = m - 1;
            } else {              
                l = m + 1;
            }
        }
        return ret;
    }
    public static boolean works (int[] piles, int h, int rate) {
        int count = 0;
        for (int pil : piles) {
            count += Math.ceil(pil * 1.0 / rate);
        }
        if (count <= h) return true;
        return false;
    }
}
