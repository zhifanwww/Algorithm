public class Solution {
    private int pos, maxLen = 0;

    public String findLongestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(pos, pos + maxLen + 1);
    }

    private void extendPalindrome(String s, int startPos, int endPos) {
        Boolean triggered = false;
        while (startPos >= 0 && endPos <= s.length() - 1 && s.charAt(startPos) == s.charAt(endPos)) {
            // Important: the conditions of this `while` block
            // 1. Be aware of the boundaries
            // 2. Use a trigger flag to ensure the comparision next will work with proper
            // and
            // valid `startPos`, `endPos`.
            // (although in this context, without flag triggered code still works, but I
            // think having such flag makes the code more readable)

            startPos--;
            endPos++;
            triggered = true;
        }

        if (triggered == true && endPos - startPos - 2 > maxLen) {
            // The last block will end up with a pos that the condition didn't meet,
            // so we should reduce the additional diistances
            maxLen = endPos - startPos - 2;
            pos = startPos + 1;
        }
    }

}

/*
 * Second Attemp:
 * 
 * Using the same algorithm the first attempt used, but well organized the code
 * structure and wrap the extendPalindrome function to a new method.
 */