// Problem: Next Permtation.
// Platform Available : Leetcode 31 , GFG.
// Difficulty: Medium.
// Companies tag : Amazone , MicroSoft , Infosys , Factset , FlipKart , Hike
// Make my Trip , Google , Sales Force , QualComn.

public class NextPermutation {
    // Time Complexity : O(n).
    // Space Complexity : O(1).
    public static void revArr(int arr[], int start, int end) {
        // Reverse a array.
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++; // move forward.
            end--; // move backward.
        }
    }

    public static void nextPermute(int arr[]) {
        // STEP 1 : Find the pivot idx pivot idx means
        // arr[i] < arr[i+1].
        int pivot = -1;
        for (int i = arr.length - 2; i >= 0; i--) { // iterate from backward.
            if (arr[i] < arr[i + 1]) {
                // Found.
                pivot = i;
                break;
            }
        }

        // STEP 2 : If pivot still -1 revrse entire array and return.
        if (pivot == -1) { // 3 , 2 , 1 reversese.
            revArr(arr, 0, arr.length - 1);
            return;
        }

        // STEP 3 : If found pivot then iterate from back found just.
        // greater element from end to pivot.
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > arr[pivot]) {
                // swap value and break.
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
                break;
            }
        }

        // STEP 4 : now reverse pivot + 1 idx to n-1 idx means arr length.
        revArr(arr, pivot + 1, arr.length - 1);
    }
}