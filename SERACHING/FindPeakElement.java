// Problem: Find Peak Element.
// Platform Availaible : Leetcode - 162 , GFG.
// Difficulty: Medium.
// Companies tag : Accolite , Amazone , Visa , Adobe , Google , Samsung
// Apple , MicroSoft , BloomBerg.

public class FindPeakElement {
    // TIME COMPLEXITY : O(LOG N).
    // SPACE COMPLEXITY : O(1).
    public static int findPeak(int A[]) {
        // -> Apply Binary Seacrh.
        // STEP 1 :Handeling all edge case or calculate length of array.
        int n = A.length;

        // -> Handel Edge Case 1.
        if (A.length == 1) {
            return 0;
        }
        // -> Handel Edge Case 2 : if A[0] > A[1] it means it also > then A[-1]
        // -> so return 0 idx : first is peak..
        if (A[0] > A[1]) {
            return 0;
        }
        // -> Handel Edge Case 3 : if A[n-1] > A[n-2] it means it also > then A[n]
        // -> So return n idx : last is peak.
        if (A[n - 1] > A[n - 2]) {
            return n - 1;
        }

        // STEP 2 : Calculate start and ending point already check for 0 or n-1 idx.
        int start = 1;
        int end = n - 2;

        while (start <= end) {
            // Calculate mid.
            int mid = start + (end - start) / 2;

            // Check mid is peak Condition : A[mid - 1] < A[mid] && A[mid] > A[mid + 1].
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                // Peak Elemnt.
                return mid;
            }
            // We are currently at increasing slope.
            if (A[mid - 1] < A[mid]) {
                start = mid + 1; // Discard left half.
            } else if (A[mid] > A[mid + 1]) {
                // at Decreasing slope.
                end = mid - 1; // Discard right half.
            } else {
                // Edge Case standing down slope : 1 5 1 4 1.
                // Option Either go left or right.
                start = mid + 1;
            }
        }

        // Return not able to find peak.
        return -1;

    }
}
