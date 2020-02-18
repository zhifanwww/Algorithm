class Solution {
    public boolean canJump(int[] nums) {

        if (nums.length < 2) {
            return true;
        }

        int startPos = 0;
        int endPos = startPos + nums[0];
        int farestSoFar = endPos;

        while (startPos != endPos) {
            System.out.println(startPos);
            for (int i = 1; i < endPos - startPos + 1; i++) {
                if ((i + startPos) < nums.length && nums[i + startPos] + i + startPos > endPos) {
                    farestSoFar = Math.max(farestSoFar, nums[i + startPos] + i + startPos);
                }
            }
            startPos = endPos;
            endPos = farestSoFar;
            if (endPos >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}