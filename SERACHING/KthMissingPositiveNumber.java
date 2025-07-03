// Problem: Kth Missing Positive Number.
// Platform Available : Leetcode - 1539 , GFG.
// Difficulty: Easy - Medium.
// Companies tag : Google , Amazone , BloomBerg , Meta , Adobe , Qualcomm , Flipkart
// CureFit , Media.net , Paytm , Samsung R&D , Swiggy , Razorpay , Ola.

public class KthMissingPositiveNumber {
    // TIME COMPLEXITY : O(Log N).
    // SPACE COMPLEXITY : O(1).
    public static int kthMissingPositive(int A[], int k) {
        // STEP 1 : Apply Binary Serach so initialize start or end.
        int start = 0;
        int end = A.length - 1;

        // STEP 2 : Find missing Number.
        while (start <= end) {
            // Calculate mid.
            int mid = start + (end - start) / 2;
            int missing = A[mid] - (mid + 1); // Mid val - mid idx + 1 it gives you curr position.

            // if missing < then k discard left half.
            if (missing < k) {
                start = mid + 1;
            } else {
                end = mid - 1; // Discard right half.
            }
        }

        // STEP 3 : then perform addition between start + k and return.
        // Because start tells us how many elements from the original array are < k-th missing.
        return start + k;
    }
}
