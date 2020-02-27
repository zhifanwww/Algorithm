class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int second = nums.length - 1;

        for (int i = zero; i <= second; i++) {
            while (nums[i] == 2 && i < second)
                swapColor(nums, i, second--);
            if (nums[i] == 0)
                swapColor(nums, i, zero++);
        }

    }

    private void swapColor(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}

/*
 * Important to check boundary under a while statement
 * 
 */