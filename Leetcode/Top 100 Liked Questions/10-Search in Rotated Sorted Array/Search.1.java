class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len <= 2) {
            for (int i = 0; i < len; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        int pivot = findPivot(nums, 0, len - 1);

        if (target >= nums[0] && target <= nums[pivot]) {
            return findTarget(nums, 0, pivot, target);
        } else if (target >= nums[pivot + 1] && target <= nums[len - 1]) {
            return findTarget(nums, pivot + 1, len - 1, target);
        } else {
            return -1;
        }

    }

    private int findPivot(int[] nums, int left, int right) {
        int middle = (left + right) / 2;
        if (nums[left] <= nums[middle] && nums[middle] <= nums[right]) {
            return middle;
        } else if (nums[left] < nums[middle] && nums[middle] > nums[right]) {
            return findPivot(nums, middle, right);
        } else {
            return findPivot(nums, left, middle);
        }
    }

    private int findTarget(int[] nums, int left, int right, int target) {
        int middle = (left + right) / 2;
        if (right - left <= 1) {
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else {
                return -1;
            }
        }
        if (nums[left] <= target && nums[middle - 1] >= target) {
            return findTarget(nums, left, middle - 1, target);
        } else if (nums[right] >= target && nums[middle] <= target) {
            return findTarget(nums, middle, right, target);
        } else {
            return -1;
        }

    }
}

// class Solution {
// public int search(int[] nums, int target) {
// int start = 0;
// int end = nums.length - 1;
// while (start <= end) {
// int mid = start + (end - start) / 2;
// if (nums[mid] == target){
// return mid;
// } else if (nums[mid] >= nums[start]) {
// if (target >= nums[start] && target < nums[mid]){
// end = mid - 1;
// } else {
// start = mid + 1;
// }
// } else {
// if (target <= nums[end] && target > nums[mid]){
// start = mid + 1;
// } else {
// end = mid - 1;
// }
// }
// }
// return -1;
// }
// }