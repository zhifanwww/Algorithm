class Solution {
    private Map<String, String> phone = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    public List<String> output = new ArrayList<String>();

    private void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            if (combination != "") {
                output.add(combination);
            }

        } else {
            String thisDigit = nextDigits.substring(0, 1);
            String letters = phone.get(thisDigit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        backtrack("", digits);
        return output;
    }
}

/*
 * Attempt 2:
 * 
 * Very interesting to think about solving this question by backtracking!
 * 
 * It's like recursion. Also, this solution avoids char by using substring all
 * the time
 */