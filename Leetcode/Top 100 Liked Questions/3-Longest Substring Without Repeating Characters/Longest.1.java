class Solution {
    public int Longest(String s) {
        int maxLength = 0;
        int slideWindowStartPointer = 0;
        int slideWindowEndPointer = 0;
        HashMap<Character, Boolean> isExisted = new HashMap<Character, Boolean>();
        /* Generic Collection classes cant be used with primitives */
        for (int i = 0; i < s.length(); i++) {
            char m = s.charAt(i);
            if (isExisted.get(m) == null) {
                isExisted.put(m, true);
            } else if (isExisted.get(m) == true) {
                for (int k = slideWindowStartPointer; k < slideWindowEndPointer; k++) {
                    if (s.charAt(k) == m) {
                        slideWindowStartPointer = k + 1;
                    }
                }
            }
            slideWindowEndPointer++;
            maxLength = Math.max(maxLength, (slideWindowEndPointer - slideWindowStartPointer));
        }
        return maxLength;
    }
}

/*
 * Key point: using sliding window to calculate the maximum length
 * 
 * May optimizate with: HashMap has a method `containKeys`, by using this method
 * code can be shortened a bit
 */