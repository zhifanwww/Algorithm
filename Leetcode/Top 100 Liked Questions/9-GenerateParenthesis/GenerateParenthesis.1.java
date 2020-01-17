class Solution {
    private List<String> ret = new LinkedList();

    public List<String> generateParenthesis(int n) {
        backtrackingGenerate("", 0, 0, n);
        return ret;

    }

    private void backtrackingGenerate(String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            ret.add(curr);
            return;
        }

        if (open < max) {
            backtrackingGenerate(curr + "(", open + 1, close, max);
        }
        if (open > close) {
            backtrackingGenerate(curr + ")", open, close + 1, max);
        }
    }
}

/*
 * How to design a backtracking:
 
 */