class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ret = new HashMap<>();
        for (String s : strs) {
            int[] alphabet = new int[26];
            for (char c : s.toCharArray()) {
                alphabet[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alphabet[i]; j++) { // 2600
                    sb.append((char)('a' + i));
                }
            }
            String check = sb.toString();
            if (ret.containsKey(check)) {
                ret.get(check).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                ret.put(check, l);
            }
        } 
        List<List<String>> retu = new ArrayList<>();
        for (String s : ret.keySet()) {
            retu.add(ret.get(s));
        }
        return retu;
    }
}
