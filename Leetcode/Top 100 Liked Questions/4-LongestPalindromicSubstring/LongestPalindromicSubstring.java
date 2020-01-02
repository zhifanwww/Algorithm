class Solution {
    public String longestPalindromicSubstring(String s) {
        // Brute force: check longest palindromic string by trying to see every
        // character as
        // center

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            char centerChar = s.charAt(i);
            // `centerChar` as center
            int maxOneSideLength = Math.min(s.length() - 1 - i, i);
            for (int m = 0; m <= maxOneSideLength; m++) {
                if (s.charAt(i - m) == s.charAt(i + m)) {
                    longest = s.substring(i - m, i + m + 1).length() > longest.length() ? s.substring(i - m, i + m + 1)
                            : longest;
                } else
                    break;
            }
            // space next to `centerChar` as center
            maxOneSideLength = Math.min(s.length() - 1 - i, i + 1);
            for (int m = 1; m <= maxOneSideLength; m++) {
                if (s.charAt(i + 1 - m) == s.charAt(i + m)) {
                    longest = s.substring(i + 1 - m, i + m + 1).length() > longest.length()
                            ? s.substring(i + 1 - m, i + m + 1)
                            : longest;
                } else
                    break;
            }
        }
        return longest;
    }
}

/*
 * Brute force
 */