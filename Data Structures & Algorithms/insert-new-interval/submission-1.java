class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][1] >= newInterval[0]) break;
            ans.add(intervals[i]);
        }
        if (i == intervals.length || intervals[i][0] > newInterval[1]) {
            ans.add(newInterval);
        } else {
            int leftMost = Math.min(newInterval[0], intervals[i][0]);
            int rightMost = Math.max(newInterval[1], intervals[i][1]);
            while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                rightMost = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            ans.add(new int[]{leftMost, rightMost});
        }
        for (; i < intervals.length; i++) {
            ans.add(intervals[i]);
        }
        int[][] ret = new int[ans.size()][2];
        for (int j = 0; j < ans.size(); j++) {
            ret[j] = ans.get(j);
        }
        return ret;
    }
}
