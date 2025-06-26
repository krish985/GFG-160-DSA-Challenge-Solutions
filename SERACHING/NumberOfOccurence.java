// Problem: Number OF Occurence.
// Problem Link : https://www.geeksforgeeks.org/dsa/count-number-of-occurrences-or-frequency-in-a-sorted-array/.
// Difficulty: Easy.
// Companies tag : Amazone , Microsoft , Adobe , Walmart labs , Oracle , TCS digital NQT 
// Accenture , Zoho , Capgemini , Infosys , Congnizant.

public class NumberOfOccurence {
    // TIME COMPLEXITY : O(LOG N) : Because Applying Binary serach.
    // SPACE COMPLEXITY : O(1).
    public static int lowerBound(int arr[], int target) {
        // -> Lower bound means first occurence of elemnet
        // -> if exist if not return just > idx val.
        // -> 1 1 2 4 5 6 : like find 3 is not available so return 4 idx.

        // STEP 1 : Take low and high pointer for binary search.
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length - 1;

        // STEP 2 : Apply binary Search.
        while (low <= high) {
            // Calculate mid.
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                // posiible store.
                ans = mid;
                high = mid - 1; // Eliminate right half.
            } else {
                low = mid + 1; // Eliminate left half.
            }
        }

        // return lower bound.
        return ans;
    }

    public static int upperBound(int arr[], int target) {
        // Just the Occrence > 1 val.
        // -> 1 2 2 3 4 : target = 2 ans -> 3 idx.

        // STEP 1 : Take low and high pointer for binary search.
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length - 1;

        // STEP 2 : Apply binary Search.
        while (low <= high) {
            // Calculate mid.
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                // posiible store.
                ans = mid;
                high = mid - 1; // Eliminate right half look for smaller idx.
            } else {
                low = mid + 1; // Eliminate left half.
            }
        }
        // return lower bound.
        return ans;
    }

    public static int countFreq(int arr[], int target) {
        // STEP 1 : APPLY BINARY SERACH.
        // Calculate lowerBound.
        int lb = lowerBound(arr, target);

        // STEP 2 : Calculate UpperBound.
        int ub = upperBound(arr, target);

        // STEP 3 : Subtract ub - lb and return ans.
        return ub - lb;
    }
}