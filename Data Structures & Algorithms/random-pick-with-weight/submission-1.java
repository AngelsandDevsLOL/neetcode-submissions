class Solution {
    int[] psa;
    public Solution(int[] w) {
        psa = new int[w.length];
        psa[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            psa[i] = psa[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int num = (int) (Math.random() * psa[psa.length - 1]) + 1;
        int ans = bSearch(psa, num);
        return ans;
    }

    public int bSearch (int[] ar, int find) {
        int l = 0, r = psa.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ar[mid] >= find) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */