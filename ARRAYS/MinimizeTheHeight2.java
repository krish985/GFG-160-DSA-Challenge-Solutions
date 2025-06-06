import java.util.Arrays;

// Problem: Minimize the Heights II.
// Link : https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1.
// Difficulty: Medium.
// Companies tag : MicroSoft , ADOBE.

public class MinimizeTheHeight2 { 
    // TIME COMPLEXITY : O(NlogN). log n for sorting.
    // SPACE COMPLEXITY : O(1).
    public static int getminDiff(int height[], int k) {
        // STEP 1 : Sort the array.
        Arrays.sort(height);

        // STEP 2 : store initial min max diffrence suppose k is 0.
        int minDiff = height[height.length - 1] - height[0];

        // STEP 3 : iterate 0 to n-1.
        for (int i = 0; i < height.length - 1; i++) {
            // Calculate the maximum height or min height.

            // Max case : curr height + k , last height fixed - k.
            int max = Math.max(height[i] + k, height[height.length - 1] - k);

            // Min Case : first height fixed + k , curr height + 1 - k.
            int min = Math.min(height[0] + k, height[i + 1] - k);

            // if minimum get negative skip.
            if (min < 0){ continue; }
                

            // STEP 5 : Calculate every time min diff and update.
            minDiff = Math.min(minDiff, max - min);
        }

        // return mindiff.
        return minDiff;
    }
}
