import java.util.HashMap;

// Problem: Longest Consecutive SubSequence.
// Platform Available : Leetcode 128 , GFG.
// Difficulty: Medium.
// Companies tag : SnapChat , Zoho , Flipkart , Morgan Stanley , Accolite , Amazon , Microsoft
// FactSet , Hike , Adobe , Google , Wipro , SAP Labs , CarWale , Atlassian , Uber , VMware
// SalesfOrce , Netflix , Goldman Sachs , BloomBerg , Intuite.

public class LongestConesecutiveSubsequence {
    // TIME COMPLEXITY : O(N).
    // SPCAE COMPLEXITY : O(N).
    public static int longestConsecutive(int arr[]){
        // STEP 1 : Create a Hashmap that containing all array value and
        // initially all are false it indicate univisited value.
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int val : arr){
            map.put(val, false);
        }

        // STEP 2 : Create a maxLength variable that tract max length
        // of consecutive.
        int maxLength = 0;

        // STEP 3 : Iterate over the array .
        for(int i=0; i<arr.length; i++){
            // initialize curr length.
            // extract curr idx value + 1 and find next value into forward.
            int currLength = 1;
            int forward = arr[i] + 1;
            while(map.containsKey(forward) && map.get(forward) == false){
                // if value person or not visited make length + 1 and 
                // do unvisited that value.
                map.put(forward, true);
                currLength++;
                forward++;  // find for next element.
            }

            // After that check same as backward we are checking consequite number that's why.
            int backward = arr[i] - 1;
            while(map.containsKey(backward) && map.get(backward) == false){
                // if value person or not visited make length + 1 and 
                // do unvisited that value.
                map.put(backward, true);
                currLength++;
                backward--;  // find for next prev element.
            }

            // After checking calculate maximum.
            maxLength = Math.max(maxLength, currLength);

        }

        // STEP 4 : Whatever the maximum simply return that value.
        return maxLength;
    }
}
