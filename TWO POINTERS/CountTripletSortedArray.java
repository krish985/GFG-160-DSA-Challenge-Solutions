// Problem: 3 Sum - Count Triplets With Given Sum In Sorted Array .
// Problem Link : https://www.geeksforgeeks.org/dsa/3-sum-count-triplets-with-given-sum-in-sorted-array/.
// Difficulty: Medium.
// Companies tag : Amzone , Google , Adobe , Goldman Sachs , Walmart labs , Flipkart

public class CountTripletSortedArray {
    // TIME COMPLEXITY : O(N ^ 2).
    // SPACE COMPLEXITY : O(1).
    public static int countTriplet(int arr[], int target) {
        // STEP 1 : Take a Count Variable that track all the
        // counts of triplets.
        int count = 0;

        // STEP 2 : Iterate over the array 0 to n-2 then apply two
        // pointer approach fix j = i+1 , k = n-1.
        for (int i = 0; i < arr.length - 2; i++) {
            // Take j and k pointer and point.
            int j = i + 1;
            int k = arr.length - 1;

            // iterate untill j < k.
            while (j < k) {
                // Extract Triplet.
                int triplet = arr[i] + arr[j] + arr[k];

                if (triplet < target) {
                    j++; // Move j

                } else if (triplet > target) {
                    k--; // decrease k by 1.

                } else if (triplet == target) {
                    // Make count++.
                    count++;
                    // Then check if next j val are same it means you found
                    // another triplet check untill both are same and count ++.
                    int index = j + 1;
                    while (index < k && arr[index] == arr[index - 1])
                        count++;
                    index++;

                    // After that decrease k by 1.
                    k--;
                }
            }
        }

        // STEP 3 : RETURN COUNT.
        return count;
    }
}