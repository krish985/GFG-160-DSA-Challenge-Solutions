// Problem: Maximum Product Subarray.
// Platform Available : Leetcode - 152 , GFG.
// Difficulty: Medium.
// Companies tag : Morgan Stanley , Amazon , Microsoft , OYO Rooms , D-E-Shaw , Google , Meta
// Intuite , Uber , Linkdin , Oracle , Cisco , PayPal , AirBnb , Pintreast , Adobe.

public class MaximumProductSubarray {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int maxProduct(int nums[]) {
        // STEP 1 : initialize variable that calculate.
        // leftproduct or rightProduct.
        int leftproduct = 1;
        int rightProduct = 1;

        int maxProduct = Integer.MIN_VALUE; // it tracks maximum product val.

        // STEP 2 : iterate over the array and evalute product.
        for (int i = 0; i < nums.length; i++) {
            // STEP 3 : if any point of time left or right product became 0 replace with 1.
            if (leftproduct == 0) {
                leftproduct = 1;
            }
            if (rightProduct == 0) {
                rightProduct = 1;
            }

            // STEP 4 : Calculate product.
            leftproduct *= nums[i]; // Calculating starting to end.
            rightProduct *= nums[nums.length - 1 - i]; // Calculating end to starting.

            // STEP 5 : Store maximum.
            maxProduct = Math.max(maxProduct, Math.max(leftproduct, rightProduct));
        }

        // return maximum product subarray.
        return maxProduct;
    }
}
