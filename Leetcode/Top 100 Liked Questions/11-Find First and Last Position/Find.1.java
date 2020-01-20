class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return findRange(nums, middle);
            }
            if (nums[start] <= target && target < nums[middle]) {
                end = middle - 1;
            } else if (nums[middle] < target && target <= nums[end]) {
                start = middle + 1;
            } else {
                break;
            }

        }

        return ret;
    }

    private int[] findRange(int[] nums, int middle) {
        int startIdx = middle, endIdx = middle;
        int[] ret = new int[2];
        while (startIdx >= 0 && nums[middle] == nums[startIdx]) {
            startIdx--;
        }
        while (endIdx <= nums.length - 1 && nums[middle] == nums[endIdx]) {
            endIdx++;
        }
        ret[0] = startIdx + 1;
        ret[1] = endIdx - 1;
        return ret;
    }
}