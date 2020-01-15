class Solution {

    private Map<Character, String> digitsMap = new HashMap() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            combinateADigit(ret, digit);

        }
        return ret;
    }

    private void combinateADigit(List<String> currList, char digit) {

        String mappedStr = digitsMap.get(digit);
        if (mappedStr == null) {
            return;
        }

        if (currList.size() == 0) {
            for (int i = 0; i < mappedStr.length(); i++) {
                char currChar = mappedStr.charAt(i);
                String s = Character.toString(currChar);
                currList.add(s);
            }
        } else {
            int len = currList.size();
            for (int m = 0; m < len; m++) {
                String currElem = currList.get(m);
                for (int i = 0; i < mappedStr.length(); i++) {
                    char currChar = mappedStr.charAt(i);
                    if (i == 0) {
                        currList.set(m, currList.get(m) + currChar);
                    } else {
                        currList.add(currElem + currChar);
                    }
                }
            }
        }

    }
}

/*
 * Attempt 1:
 * 
 * Key function: traverse one String and add the results to the obtained Array
 * 
 * 
 * IMPROVEMENT:
 * 
 * 1. Better known of JAVA APIs of String and Char can aviod several lines of
 * this code.
 * 
 * 2. Design for the alogorithm structure.
 * 
 * 3. Better naming.
 */