import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        backtracking(finalList, tempList, nums);
        return finalList;

    }

    private void backtracking(List<List<Integer>> finalList, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            finalList.add(new LinkedList<>(tempList)); // add copy of tempList otherwise only reference is added
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]) == true)
                    continue;
                tempList.add(nums[i]);
                backtracking(finalList, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}