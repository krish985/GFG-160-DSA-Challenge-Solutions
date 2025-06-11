// Problem: Smallest Positive Missing.
// Platform Available : Leetcode - 41 , GFG.
// Difficulty: HARD.
// Companies tag : Accolite , Amazon , Snapdeal , Google , Uber , Flipkart , Atlassian
// Samsung , Adobe , Salesforce.

public class SmallestPositiveMissing {
    // TIME COMPLEXITY : O(3N) overall : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int firstMissingPositive(int nums[]) {
        // STEP 1 : iterate over the array if any val <= 0 replace with length of arr + 1.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        // STEP 2 : Iterate over the array again take that abs val subtract with 1.
        // then check that idx lie betwwen range of array. it means < nums.length.
        // also check that val not be negative it means num[idx] > 0.
        // if satisfied all all condition make that value negative.
        for (int i = 0; i < nums.length; i++) {
            // Calculate idx.
            int idx = Math.abs(nums[i]) - 1;

            // Check out of bound condition. and val will not negative.
            if (idx < nums.length && nums[idx] > 0) {
                // Make value Negative.
                nums[idx] *= -1;
            }
        }

        // STEP 3 : iterate again and find the first non negative number.
        // if found return that idx + 1.
        for (int i = 0; i < nums.length; i++) {
            // Find non negative value.
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // STEP 4 : if not able to found non negative value return.
        return nums.length + 1;
    }
}
