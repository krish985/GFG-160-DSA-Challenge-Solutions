import java.util.HashMap;

// Problem: SubArray Sum Equals K.
// Platform Available : Leetcode 560 , GFG.
// Difficulty: Medium.
// Companies tag : Amazone , Microsoft , Google , Meta , Apple , Adobe , ByteDance
// BloomBerg , Goldman Sachs , Ebay , Qualcomm , Expedia , MindTree , Razorpay
// Zoho , Flipkart , Phonepay , Paytm , Zerodha , Curefit.

public class SubarraySumEqualsK {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(2N).
    public static int countSubarray(int arr[], int k){
        // STEP 1 : Calculate Prefix sum of an array.
        // is a running sum of an array.
        int prefixSum[] = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i=1; i<prefixSum.length; i++){
            // prev val of prefix sum + curr val of an array.
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        // STEP 2 : Create a HashMap for track subarray count where
        // storeing key as prefix sum and value their frequency.
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // For edge case if prefix sum == target subtracting
        // prefixsum[i] == k it's give 0 so you look up on the map
        // that's why adding their frequency to 1.
        map.put(0, 1);
        int count = 0;    // It Track subarray.

        // STEP 3 : Iterate over the prefix Sum Array.
        for(int i=0; i<prefixSum.length; i++){
            // Extract Complement.
            int complement = prefixSum[i] - k;

            // Check for map complement exist.
            if(map.containsKey(complement)){
                // If Exist.
                count+= map.get(complement);
            }

            // Add into map if already present update frequency by 1.
            map.put(prefixSum[i] , map.getOrDefault(prefixSum[i], 0) + 1);
        }

        // STEP 4 : Return Subarray sum Equal k count.
        return count;
    }
}
