class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> dic = new HashMap<>();
        HashSet<Character> taken = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (dic.containsKey(s.charAt(i))) {
                if (dic.get(s.charAt(i)) != t.charAt(i)) return false;
            } else if (!taken.contains(t.charAt(i))) {
                dic.put(s.charAt(i), t.charAt(i));
                taken.add(t.charAt(i));
            } else return false;
        } 
        return true;
    }
}