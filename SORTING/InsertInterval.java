import java.util.ArrayList;
// Problem: Insert Interval.
// Platform Available : Leetcode 57 , GFG.
// Difficulty: Medium.
// Companies tag : Amazone , Google , Meta , Adobe , Apple , SamSung , VMware , Intuite
// Goldman Sachs , Flipkart , Infosys , Wipro , TCS(Digital).

public class InsertInterval {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static ArrayList<int[]> insertInterval(int intervals[][], int newInterval[]) {
        // STEP 1 : Create array list of int that store non overlapping interval.
        int n = intervals.length;
        int i = 0;
        ArrayList<int[]> result = new ArrayList<>();

        // STEP 2 : Fisrtly add non overlappping interval if it is availaible.
        // -> interval ending time should < newinterval starting time.
        while (i < n && intervals[i][1] < newInterval[0]) {
            // Add into list.
            result.add(intervals[i]);
            i++;
        }

        // STEP 3 : NOW merge overlapping interval.
        // -> take min starting point and maximum end point.
        // -> interval starting time <= newinterval ending time.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // update min or max.
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // STEP 4 : add that interval into list.
        result.add(newInterval);

        // STEP 5 : Now add remaning non-overlapp interval into list.
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Finally return arraylist for non overlapping interval.
        return result;

    }
}
