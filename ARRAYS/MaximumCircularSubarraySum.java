import java.util.Arrays;

// Problem: Maximum Circular Subarray Sum.
// Platform Available : Leetcode - 918 , GFG.
// Difficulty: HARD.
// Companies tag : Goldman Sachs , Amazon , Microsoft , Google , Paytm , Flipkart , Directi
// Samsung , Adobe .

public class MaximumCircularSubarraySum {
    // TIME COMPLEXITY : O(3N) overall : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int maxSubarray(int arr[]) {
        int currSum = arr[0];
        int maxSum = arr[0];

        // iterate and calculate the maximum subarray sum.
        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max(arr[i], arr[i] + currSum);
            maxSum = Math.max(maxSum, currSum);
        }

        // return maximum subarray sum.
        return maxSum;
    }

    public static int minSubarray(int arr[]) {
        int currSum = arr[0];
        int minSum = arr[0];

        // iterate and calculate the minimum subarray sum.
        for (int i = 1; i < arr.length; i++) {
            currSum = Math.min(arr[i], arr[i] + currSum);
            minSum = Math.min(minSum, currSum);
        }

        // return minimum subarray sum.
        return minSum;
    }

    public static int circularSubarraySum(int arr[]) {
        // STEP 1 : Calculate minSubarray sum or maximumsubarray sum.
        int max = maxSubarray(arr);
        int min = minSubarray(arr);

        // STEP 2 : Calculate the entier array sum.
        int totalSum = Arrays.stream(arr).sum();

        // STEP 3 : Find circular subarray ( totalsum - min ) Beacuse you remove minimum
        // sum.
        // then rest of the array will maximum subarray sum in circular fashion.
        int circular = (totalSum - min);

        // STEP 4 : if max > 0 return max of max , circular.
        if (max > 0) {
            return Math.max(max, circular);
        }

        // if not return max.
        // EDGE CASE : all the element are negative. in that case circular sum is invalid
        // simply return maximum subarray.
        return max;
    }
}
