// Problem: Maximum Subarray Sum - Kadane's Algorithm.
// Platform Available : Leetcode - 53 , GFG.
// Difficulty: Medium.
// Companies tag : Zoho , Flipkart , Morgan Stanley , Accolite , Amazon
// Microsoft , Samsung , Snapdeal , 24*7 Innovation Labs , Citrix , D-E-Shaw
// FactSet ,Hike , Housing.com , MetLife , Ola Cabs ,Oracle , Payu , Teradata
// Visa , Walmart , Adobe , Google , Arcesium.

public class MaximumSubarray {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int maxSubarray(int nums[]) {
        // STEP 1 : Initialize some variable that keep tracks.
        int currSum = nums[0];
        int maxSum = nums[0]; // it track overall maximum sum

        // STEP 2 : Iiterate over the array 1 to n
        // Calculate max sum.
        for (int i = 1; i < nums.length; i++) {
            // max of currval or currval + prevval.
            currSum = Math.max(nums[i], currSum + nums[i]);

            // Evalute maximum.
            maxSum = Math.max(maxSum, currSum);
        }

        // return maximum subarray sum.
        return maxSum;
    }
}
