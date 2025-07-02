import java.util.Arrays;

// Problem: Aggressive Cows .
// Problem Link : https://www.geeksforgeeks.org/dsa/assign-stalls-to-k-cows-to-maximize-the-minimum-distance-between-them/
// Difficulty: Medium - Hard.
// Companies tag : Infosys , Amazon , Microsoft , Google , CureFit , Uber
// Ola , Flipkart , Swiggy , Samsung , Atlassian , DE Shaw , Sprinkler.

public class AggressiveCows {
    // TIME COMPLEXITY: O(N * log(Max Distance))
    // SPACE COMPLEXITY: O(1)
    public static boolean canWePlaceCows(int[] stalls, int minDistanceAllowed, int cows) {
        // STEP 1: Place the first cow at the first stall
        int cowsPlaced = 1;
        int lastPlacedPosition = stalls[0];

        // STEP 2: Try placing remaining cows
        for (int i = 1; i < stalls.length; i++) {
            // Check if current stall is at least minDistanceAllowed away from
            // lastPlacedPosition
            if (stalls[i] - lastPlacedPosition >= minDistanceAllowed) {
                // Place the cow
                cowsPlaced++;
                lastPlacedPosition = stalls[i];
            }

            // If all cows are placed successfully, return true
            if (cowsPlaced == cows) {
                return true;
            }
        }

        // Could not place all cows with at least minDistanceAllowed distance
        return false;
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        // STEP 1: Sort the stall positions to check distance between stalls
        Arrays.sort(stalls);

        // STEP 2: Set search space for binary search
        int start = 1; // Minimum possible distance
        int end = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int maxMinDistance = 0; // Store answer

        // STEP 3: Apply Binary Search on distance
        while (start <= end) {
            // Find middle distance to try placing cows
            int mid = start + (end - start) / 2;

            // Check if it's possible to place all cows with at least 'mid' distance
            if (canWePlaceCows(stalls, mid, cows)) {
                // If possible, store answer and try to maximize distance
                maxMinDistance = mid;
                start = mid + 1; // Eliminate left half, try for bigger distance
            } else {
                // If not possible, reduce the distance
                end = mid - 1; // Eliminate right half
            }
        }

        // Return the largest minimum distance found
        return maxMinDistance;
    }
}
