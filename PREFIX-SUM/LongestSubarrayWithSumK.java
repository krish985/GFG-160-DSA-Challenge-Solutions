import java.util.HashMap;

// Problem: Longest Subarray with sum k .
// Problem link : https://www.geeksforgeeks.org/dsa/longest-sub-array-sum-k/.
// Difficulty : Medium.
// Companies tag : Amazon , Google , Microsoft , Adobe , Paytm , Flipkart , Ola
// Goldman Sachs , Accenture.

public class LongestSubarrayWithSumK {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static int longestSubarr(int arr[], int k){
        // STEP 1 : Create a HashMap that store prefix sum of an arr.
        HashMap<Integer,Integer> prefixSeenMap = new HashMap<>();

        // STEP 2 : Create max variable that store longest subarray length
        // and initialize prefix sum that store running sum.
        int maxLength = 0;
        int prefixSum = 0;

        // STEP 3 : Iterate over the array.
        for(int i=0; i<arr.length; i++){
            // Calculate running sum.
            prefixSum+= arr[i];

            // prefixSum == k store maximum of max , i+1.
            if(prefixSum == k){
                maxLength = Math.max(maxLength, i+1);
            }

            // check if (prefixsum - k) present in map  means if you remove that
            // remaing element became sum equal k.
            if(prefixSeenMap.containsKey(prefixSum - k)){
                // store max do curr idx - seen idx.
                maxLength =  Math.max(maxLength , i - prefixSeenMap.get(prefixSum - k));
            }

            // If prefix sum ! available in map store.
            if(!prefixSeenMap.containsKey(prefixSum)){
                prefixSeenMap.put(prefixSum, i);
            }
        }

        // STEP 4 : return longest subarray woth sum equals k.
        return maxLength;
    }
}