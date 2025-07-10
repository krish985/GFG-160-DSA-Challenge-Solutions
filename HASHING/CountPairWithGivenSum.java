import java.util.HashMap;

// Problem: 2 Sum - Count pairs with given sum.
// Problem Link : https://www.geeksforgeeks.org/dsa/count-pairs-with-given-sum/
// Difficulty: Easy.
// Companies tag : Amazone , Microsoft , Google , Flipkart , Adobe , Paytm
// Oracle , Samsung , TCS (Digital).

public class CountPairWithGivenSum {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static int countPairs(int arr[],int target){
        // STEP 1 : Create hashmap that store val and their Occurnce
        // to check if it value previously lie and also create count
        // variable that tracks pair.
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        // STEP 2 : Iterate over the array and count pairs.
        for(int i=0; i<arr.length; i++){
            // Extract value and complemnt.
            int curVal = arr[i];
            int complement = target - curVal;

            // Check the complement exist if exist add their occurence
            // into count variable.
            if(map.containsKey(complement)){
                // Add Occurence.
                count+= map.get(complement);
            }
            // then add value into map if already present increase occurnce
            // by one.
            map.put(curVal, map.getOrDefault(curVal, 0)+1);
        }

        // STEP 3 : Return count variable.
        return count;

    }
}
