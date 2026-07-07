class Solution {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && !((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) i++;
            while (j > 0 && (s.charAt(j) < 'A' || s.charAt(j) > 'Z')) j--;
            if (i == s.length()) break;
            System.out.print(i + " " + j);
            if (s.charAt(i) != s.charAt(j)) {
                System.out.print(i + " " + j);
                return false;
            }
            j--;
        }
        return true;
    }
}
