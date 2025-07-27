import java.util.HashMap;

// Problem: Longest Subarray 0 and 1 .
// Platform Available : Leetcode 525 , GFG.
// Difficulty : Medium.
// Companies tag : Paytm , Morgan Stanley , Amazon , MakeMyTrip , Intuite , Linkdin
// Adobe , VMware , Flipkart , Google.

public class LongestSubarray0and1 {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static int maxLength(int arr[]){
        // STEP 1 : Create hashmap that store prefixsum and their idx.
        HashMap<Integer,Integer> prefixmap = new HashMap<>();

        // STEP 2 : Create a prefixSum variable that store running sum
        // or initiliaze maxlength variable.
        int prefixSum = 0;
        int maxLength = 0;

        // STEP 3 : Iterate over the array.
        for(int i=0; i<arr.length; i++){
            // if arr[i] == 0 subtract prefixsum by 1 else add by 1.
            prefixSum+= (arr[i] == 0) ? -1 : 1;

            // if any point of time prefixSum == 0 add maximum of max ans i+1.
            if(prefixSum == 0){
                maxLength = Math.max(maxLength, i+1);
            }

            // now check prefixsum till point avialibe in map if available it means 
            // found another subarray whose equal.
            if(prefixmap.containsKey(prefixSum)){
                maxLength = Math.max(maxLength, i - prefixmap.get(prefixSum));
            }else{
                // if Not available add into map.
                prefixmap.put(prefixSum, i);
            }
        }

        // STEP 4 : Return maxLength.
        return maxLength;
    }
}
