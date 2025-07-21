import java.util.ArrayList;

// Problem: Indexes of Subarray Sum.
// Problem Link : https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1.
// Difficulty : Medium.
// Companies tag : Amazone , Meta , Google , Visa , Netflix , Apple , Swiggy
// Zomato , Phonepay , Oracle , Adobe , Salesforce.

public class IndexSubarraySum {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static ArrayList<Integer> subarraySum(int arr[],int target){
        // STEP 1 : Use sliding window approach using two pointer.
        // take a left right pointer intitaly point 0 idx.
        int left = 0;
        int right = 0;
        int sum = 0;   // it contain summision on arr val.

        // STEP 2 : Create a Arraylist of integer where store idx by + 1.
        ArrayList<Integer> ans = new ArrayList<>();

        // STEP 3 : Iterate over the array untill right < arr.length.
        while(right < arr.length){
            // add into sum.
            sum+= arr[right];

            // Check if any point of time sum is > target
            // reduce the sum shrink the window move left.
            while(sum > target && left <= right){
                sum-=arr[left];
            } 

            // if sum equals to target return their idx by +1.
            if(sum == target){
                ans.add(left+1);
                ans.add(right+1);
                return ans;
            }

            // it last move right +=1.
            right++;
        }

        // STEP 4 : Return -1 not able to find subarray whose sum
        // equals to target.
        ans.add(-1);
        return ans;
    }
}
