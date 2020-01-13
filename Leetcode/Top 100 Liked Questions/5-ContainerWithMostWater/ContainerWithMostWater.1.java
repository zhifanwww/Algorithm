class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int maxContainer = (len - 1) * Math.min(height[0], height[len - 1]);
        int maxLeftHeight = height[0];
        int maxRightHeight = height[len - 1];
        int startPos = 0;
        int endPos = len - 1;
        while (startPos < endPos) {
            if (maxLeftHeight <= maxRightHeight) {

                while (startPos < endPos && height[startPos] <= maxLeftHeight) {
                    startPos++;
                }
                maxLeftHeight = height[startPos];
                maxContainer = Math.max(maxContainer, (endPos - startPos) * Math.min(maxRightHeight, maxLeftHeight));
            } else if (maxLeftHeight > maxRightHeight) {

                while (endPos > startPos && height[endPos] <= maxRightHeight) {
                    endPos--;
                }
                maxRightHeight = height[endPos];
                maxContainer = Math.max(maxContainer, (endPos - startPos) * Math.min(maxLeftHeight, maxRightHeight));
            }

        }
        return maxContainer;

    }

}

/**
 * Attempt 1:
 * 
 * Algorithm ok, may want to optimize the code writing the next attempt
 */