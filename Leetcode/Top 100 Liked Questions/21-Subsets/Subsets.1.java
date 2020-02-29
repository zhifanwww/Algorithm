class Solution {
    ArrayList ret = new ArrayList<>();
    int targetLength;

    public List<List<Integer>> subsets(int[] nums) {
        for (targetLength = 0; targetLength < nums.length + 1; targetLength++) {
            backtracking(0, new ArrayList<>(), nums);
        }
        return ret;

    }

    private void backtracking(int add_pos, ArrayList curr, int[] nums) {
        if (curr.size() == targetLength) {
            ret.add(new ArrayList(curr));
            return;
        }

        for (int i = add_pos; i < nums.length; i++) {
            curr.add(nums[i]);
            backtracking(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }

    }
}

/* Classic backtracking soluion */