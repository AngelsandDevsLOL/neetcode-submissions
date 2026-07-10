class Solution {
    HashMap<String, Integer> best = new HashMap<String, Integer>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int num = ladderLength2(beginWord, endWord, wordList);
        if (num == Integer.MAX_VALUE) return 0;
        return num + 1;
    }
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        if (best.containsKey(beginWord)) return best.get(beginWord);
        int ans = Integer.MAX_VALUE;
        List<String> tmp = new ArrayList<>(wordList);
        Queue<String> q = new LinkedList<>();
        for (String next : wordList) {
            if (compare(beginWord, next)) {
                tmp.remove(next);
                int num = ladderLength2(next, endWord, tmp);
                System.out.println(beginWord + " " + next + " " + num);
                if (num != Integer.MAX_VALUE) ans = Math.min(ans, num + 1);
                tmp.add(next);
            }
        }
        best.put(beginWord, ans);
        System.out.println(beginWord + " " + ans);
        return ans;
    }
    public boolean compare(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }
        return true;
    }
}
