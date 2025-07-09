import java.util.HashMap;

// Problem: Two Sum .
// Platform Available : Leetcode 1 , GFG.
// Difficulty: Medium.
// Companies tag : Zoho , Flipkart , Morgan Stanley , Accolite , Amazon , Microsoft
// FactSet , Hike , Adobe , Google , Wipro , SAP Labs , CarWale , Atlassian , Uber
// SalesfOrce , Netflix , Goldman Sachs , BloomBerg , Intuite.

public class TwoSum {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    public static int[] findTwoSum(int arr[],int target) {
        // STEP 1 : Create Hashmap that store arr val or thier idx.
        HashMap<Integer,Integer> map = new HashMap<>();

        // STEP 2 : Iterate over the array.
        for(int i=0; i<arr.length; i++){
            // Extract curr val or complemnt.
            int curVal = arr[i];
            int complemnt = target - curVal;

            // if that complemnt available in map it two value
            // available that sum makes equals target.
            if(map.containsKey(complemnt)){
                // return that complemnt idx or curr idx.
                return new int[]{map.get(complemnt),i};
            }

            // If not available add currval and their idx into map.
            map.put(curVal, i);
        }

        // STEP 3 : Not able to find  pair return {-1,-1}
        return new int[]{-1,-1};

    }
}