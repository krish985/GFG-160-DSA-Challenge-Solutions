import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Problem: Find All Triplet With Zero Sum.
// Problrm link : https://www.geeksforgeeks.org/dsa/find-triplets-array-whose-sum-equal-zero/.
// Difficulty: Medium.
// Companies tag : Amazone , Microsft , Adobe , Meta , Samsung , Paytm , Walmart Labs 
// OLA , Swiggy , Zomato.

public class FindAllTripletZeroSum {
    // TIME COMPLEXITY : O(N ^ 2).
    // SPACE COMPLXITY : O(N ^ 2).
    public static List<List<Integer>> findTriplet(int arr[]) {
        // STEP 1 : Map to store all previous values and their indices
        HashMap<Integer, List<Integer>> valueToIndices = new HashMap<>();

        // STEP 2 :Result list to store all valid triplets
        List<List<Integer>> triplets = new ArrayList<>();

        int n = arr.length;

        // STEP 3 : Loop through all pairs (j, k)
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {

                // Find the value needed at i to make the sum zero
                int required = -(arr[j] + arr[k]);

                // Check if such a value already appeared before index j
                if (valueToIndices.containsKey(required)) {
                    for (int i : valueToIndices.get(required)) {
                        // Add the valid triplet
                        triplets.add(Arrays.asList(i, j, k));
                    }
                }
            }

            // Now mark arr[j] as seen, so it can be used as i in future iterations
            valueToIndices.putIfAbsent(arr[j], new ArrayList<>());
            valueToIndices.get(arr[j]).add(j);
        }

        // return all triplets.
        return triplets;
    }
}
