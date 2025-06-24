import java.util.Arrays;
import java.util.Comparator;

// Problem:  Non-overlapping Intervals.
// Platform Available : Leetcode 235 , GFG.
// Difficulty: Medium.
// Companies tag : Amazone , Google , Meta , Microsoft , Apple , Adobe , VMware , Uber
// Goldman Sachs.

public class NonOverLappingInterval {
    // TIME COMPLEXITY : O(N LOG N) For Sorting.
    // SPACE COMPLEXITY : O(1).
    public static int eraseOverlapInterval(int intervals[][]) {
        // STEP 1 : SORT intervals bases on their ending time.
        Arrays.sort(intervals, Comparator.comparingInt((a) -> a[1]));

        // STEP 2 : Store 1 interval ending time for comparing.
        int end = intervals[0][1];

        // STEP 3 : initialiaze count variable that count over-lap interval.
        int count = 0;

        // STEP 4 : Iterate 1 to intervals.length.
        for (int i = 1; i < intervals.length; i++) {
            // If cuur starting point < previous ending.
            // Means overlapp situtaion so make count++.
            if (intervals[i][0] < end) {
                count++;
            } else {
                // Non-overlap Condition.
                end = intervals[i][1]; // Store curr end time.
            }
        }

        // return count.
        return count;
    }
}
