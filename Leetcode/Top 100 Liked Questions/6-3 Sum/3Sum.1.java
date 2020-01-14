import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList();

        for (int i = 0; i < nums.length - 2; i++) {
            int loIdx = i + 1, hiIdx = nums.length - 1, targetSum = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (loIdx < hiIdx) {
                if (nums[loIdx] + nums[hiIdx] == targetSum) {
                    ret.add(Arrays.asList(nums[i], nums[loIdx], nums[hiIdx]));

                    while (loIdx < hiIdx && nums[loIdx] == nums[loIdx + 1])
                        loIdx++;
                    while (loIdx < hiIdx && nums[hiIdx] == nums[hiIdx - 1])
                        hiIdx--;
                    loIdx++;
                    hiIdx--;
                } else if (nums[loIdx] + nums[hiIdx] > targetSum) {
                    hiIdx--;
                } else
                    loIdx++;
            }
        }
        return ret;
    }
}

/**
 * This is a reimplementation
 * 
 * 1. Sort the array
 * 
 * 2. Iterate each element, find /two sum/ from the remaining array from the
 * iterated one
 * 
 * Key: VERY IMPORTANT to avoid those repeated elements after sorting
 */