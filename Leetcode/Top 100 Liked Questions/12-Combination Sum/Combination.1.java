import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> ret = new LinkedList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        findTargetCombination(new LinkedList<Integer>(), candidates, 0, target);
        return ret;

    }

    private void findTargetCombination(LinkedList<Integer> curr, int[] sortedCandidates, int i, int target) {

        if (target == 0) {
            ret.add(curr);
            return;
        }

        while (i < sortedCandidates.length && target > 0 && sortedCandidates[i] <= target) {
            LinkedList<Integer> copiedCurr = new LinkedList<Integer>(curr);
            copiedCurr.add(sortedCandidates[i]);
            findTargetCombination(copiedCurr, sortedCandidates, i, target - sortedCandidates[i]);
            i++;
        }
        return;

    }
}