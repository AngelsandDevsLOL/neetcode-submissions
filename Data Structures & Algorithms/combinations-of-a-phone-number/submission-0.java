class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> l = letterCombinations(digits.substring(0, digits.length() - 1));
        if (l.size() == 0) l.add("");
        List<String> ret = new ArrayList<>();
        String[] ar = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for (String str : l) {
            String string = ar[digits.charAt(digits.length() - 1) - '0'];
            for (int i = 0; i < string.length(); i++) {
                ret.add(str + string.substring(i, i + 1));
            }
        }
        return ret;
    }
}
