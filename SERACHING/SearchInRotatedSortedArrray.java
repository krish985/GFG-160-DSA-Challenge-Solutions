// Problem: Search in Rotated Sorted Array.
// Platform Availaible : Leetcode - 33 , GFG.
// Difficulty: Easy.
// Companies tag : Paytm , Flipkart , Amazon , Microsoft , Snapdeal , D-E-Shaw ,FactSet , Hike 
// MakeMyTrip , Intuit , Adobe , Google , BankBazaar ,Times Internet , Uber , Cisco , Meta
// Goldman Sachs , VMware , Apple.

public class SearchInRotatedSortedArrray {
    // TIME COMPLEXITY : O(LOG N).
    // SPACE COMPLEXITY : O(1).
    public static int search(int A[], int target) {
        // STEP 1 : Apply Binary Serach Calculate start or end idx.
        int start = 0;
        int end = A.length - 1;

        // STEP 2 : iterate untill start <= end.
        while (start <= end) {
            // Calculate mid.
            int mid = start + (end - start) / 2;

            // If mid is a target return that idx.
            if (A[mid] == target) {
                return mid;
            }
            // IF array is rotated on half always be sorted.
            // Check which half is sorted go with that.
            if (A[start] <= A[mid]) {
                // Left Half Sorted.
                // -> Check value lie in that range.
                if (A[start] <= target && target <= A[mid]) {
                    end = mid - 1; // Eliminate right half.
                } else {
                    start = mid + 1; // Eliminate left half.
                }
            } else {
                // Right Half is Sorted.
                // -> Check value lie in that range.
                if (A[mid] <= target && target <= A[end]) {
                    start = mid + 1; // Eliminate left Half.
                } else {
                    end = mid - 1; // Eliminate right Half.
                }
            }
        }

        // Return if not able to found target.
        return -1;
    }
}
