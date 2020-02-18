import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        Arrays.sort(intervals, (int[] interval1, int[] interval2) -> interval1[0] > interval2[0] ? 1
                : interval1[0] < interval2[0] ? -1 : 0);
        for (int[] interval : intervals) {
            int size = result.size();
            if (size == 0 || (result.get(size - 1)[1] < interval[0])) {
                result.add(interval);
            } else {
                result.set(size - 1, new int[] { Math.min(result.get(size - 1)[0], interval[0]),
                        Math.max(result.get(size - 1)[1], interval[1]) });
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}