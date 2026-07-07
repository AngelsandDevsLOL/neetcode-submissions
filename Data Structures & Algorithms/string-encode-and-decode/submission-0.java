class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length() + " " + strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> aList = new ArrayList<>();
        while (!str.isEmpty()) {
            int next = str.indexOf(" ");
            int len = Integer.parseInt(str.substring(0, next));
            aList.add(str.substring(next + 1, next + len + 1));
            str = str.substring(next + 1 + len);
        }
        return aList;
    }
}
