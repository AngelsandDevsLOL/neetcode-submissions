class Solution {
    public long putMarbles(int[] weights, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (int i = 0; i < weights.length - 1; i++) {
            int sum = weights[i] + weights[i + 1];
            pq.add(sum); pq2.add(-sum);
        }
        int tmp = k - 1;
        long runningSum = 0;
        while (tmp > 0) {
            System.out.println(pq.peek());
            runningSum -= pq.poll();
            tmp--;
        }
        tmp = k - 1;
        while (tmp > 0) {
            runningSum -= pq2.poll();
            tmp--;
        }
        return runningSum;
    }
}