class Solution {
    private List<String> ret = new LinkedList();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrackingGenerate(sb, 0, 0, n);
        return ret;

    }

    private void backtrackingGenerate(StringBuilder curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            ret.add(curr.toString());
            return;
        }

        if (open < max) {
            backtrackingGenerate(curr.append('(') , open + 1, close, max);
            curr.deleteCharAt(curr.length()-1);
        }
        if (open > close) {
            backtrackingGenerate(curr.append(')'), open, close + 1, max);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}

/*
IMPROVED SOLUTION:
In JAVA, using StringBuilder instead of String is very neccessary at some time.
String is immutable which means every operations on a string leads to a new string object at last,
while StringBuilder is mutable.
Operations on StringBuilde can save more memory overhead.
*/