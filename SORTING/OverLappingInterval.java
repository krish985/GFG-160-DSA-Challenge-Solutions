import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Problem: Over Lapping Interval.
// Platform Available : Leetcode 56 , GFG.
// Difficulty: Medium.
// Companies tag : Amazon , Microsoft , Google , Nutanix , Zoho , Apple , Netflix , Meta
// Stripe , Goldman Sachs , Service Now , VMware , Oracle , Adobe , Lyft , Uber , Airbnb
// DropBox , Sales Force , BllomBerg , Zillow , Flipkart , Swiggy , Ola , Zomato , Cred
// RazorPay , Cisco , Intuite , PayPal , Linkdin , Twitter , Tata 1mg , SamSung R&D.
 
public class OverLappingInterval {
    // TIME COMPLEXITY : O(N LOG N) log n for sorting.
    // SPACE COMPLEXITY : O(N).
    public static List<int[]> mergeOverlap(int intervals[][]) {
        // STEP 1 : Sort Array bases on their starting time.
        // Beacause check the curr interval start lesser then prev end.
        Arrays.sort(intervals, Comparator.comparingInt((a) -> a[0]));

        // STEP 2 : Create a list of int[] that store merge overlapp.
        List<int[]> list = new ArrayList<>();

        // STEP 3 : Create a newinterval array intially add into list.
        int newInterval[] = intervals[0]; // Add first interval.

        // STEP 4 : Iterate 1 to n.
        for (int i = 1; i < intervals.length; i++) {
            // if curr interval starting time <= previous ending
            // point it means overallping situtaion.
            if (intervals[i][0] <= newInterval[1]) {
                // Store the max ending time.
                // Compare curr ending or prev ending
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else {
                // there is no overlapping interval.
                // add curr interval into list.
                newInterval = intervals[i];
                list.add(newInterval); // ADD new.
            }
        }

        // return list of non overlapping interval.
        return list;
    }
}
