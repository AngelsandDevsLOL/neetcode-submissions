class Solution {
    public String minWindow(String s, String t) {
        HashSet<Character> hSet = new HashSet<>();
        int[] count = new int['z' - 'A' + 1];
        for (int i = 0; i < t.length(); i++) {
            hSet.add(t.charAt(i));
            count[t.charAt(i) - 'A']++;
        }
        String ret = "";
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int unique = hSet.size();
            int[] window = new int['z' - 'A' + 1];
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!hSet.contains(c)) continue;
                window[c - 'A']++;
                if (window[c - 'A'] == count[c - 'A']) {
                    unique--;
                    if (unique == 0) {
                        if (j - i + 1 < ans) {
                            ret = s.substring(i, j + 1);
                            ans = ret.length();
                        }
                        break;
                    }
                }
            }
        }
        return ret;
    }
}